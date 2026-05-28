package com.ravi.orbit.service.impl;

import com.ravi.orbit.dto.CartDTO;
import com.ravi.orbit.dto.CartItemDTO;
import com.ravi.orbit.dto.ProductDTO;
import com.ravi.orbit.entity.Cart;
import com.ravi.orbit.entity.CartItem;
import com.ravi.orbit.entity.Product;
import com.ravi.orbit.entity.ProductVariant;
import com.ravi.orbit.entity.User;
import com.ravi.orbit.exceptions.BadRequestException;
import com.ravi.orbit.repository.CartItemRepository;
import com.ravi.orbit.repository.CartRepository;
import com.ravi.orbit.service.ICartService;
import com.ravi.orbit.service.IProductService;
import com.ravi.orbit.service.IUserService;
import com.ravi.orbit.utils.MyConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class CartServiceImpl implements ICartService {

    private final IUserService userService;

    private final IProductService productService;

    private final CartRepository cartRepository;

    private final CartItemRepository cartItemRepository;

    @Override
    public CartDTO addToCart(CartDTO request) {

        User customer = userService.getUserPrincipal();

        /*
         * GET VARIANT
         */
        ProductVariant variant = productService.getProductVariantById(request.getVariantId());

        /*
         * VALIDATIONS
         */
        if (!Boolean.TRUE.equals(variant.getIsAvailable())) {
            throw new BadRequestException("Product variant is not available.");
        }

        if (variant.getQuantity() < request.getQuantity()) {
            throw new BadRequestException("Insufficient stock available.");
        }

        /*
         * FIND CUSTOMER CART
         */
        Cart cart = cartRepository.findByCustomerId((customer.getId()))
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setCustomer(customer);
                    return cartRepository.save(newCart);
                });

        /*
         * CHECK IF ITEM ALREADY EXISTS
         */
        Optional<CartItem> existingCartItemOptional =
                cartItemRepository.findByCartIdAndVariantId(cart.getId(), variant.getId());

        /*
         * ITEM ALREADY EXISTS
         * UPDATE QUANTITY
         */
        if (existingCartItemOptional.isPresent()) {

            CartItem existingCartItem =
                    existingCartItemOptional.get();

            int newQuantity =
                    existingCartItem.getQuantity()
                            + request.getQuantity();

            /*
             * STOCK VALIDATION
             */
            if (newQuantity > variant.getQuantity()) {
                throw new BadRequestException("Cannot add more items than available stock.");
            }

            existingCartItem.setQuantity(newQuantity);

            cartItemRepository.save(existingCartItem);
        }

        /*
         * CREATE NEW CART ITEM
         */
        else {

            CartItem cartItem = new CartItem();

            cartItem.setCart(cart);

            cartItem.setProduct(variant.getProduct());

            cartItem.setVariant(variant);

            cartItem.setQuantity(request.getQuantity());

            cartItemRepository.save(cartItem);
        }

        request.setId(cart.getId());
        return request;
    }

    @Override
    public CartDTO getMyCart() {

        User customer = userService.getUserPrincipal();

        Cart cart = cartRepository
                .findByCustomerId(customer.getId())
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setCustomer(customer);
                    return cartRepository.save(newCart);
                });

        List<CartItem> cartItems = cartItemRepository.findAllByCartId(cart.getId());

        /*
         * RESPONSE DTO
         */
        CartDTO response = new CartDTO();

        response.setId(cart.getId());

        List<CartItemDTO> cartItemDTOList = new ArrayList<>();

        BigDecimal totalAmount = BigDecimal.ZERO;

        int totalItems = 0;

        /*
         * CART ITEMS
         */
        for (CartItem cartItem : cartItems) {

            Product product = cartItem.getProduct();

            ProductVariant variant = cartItem.getVariant();

            BigDecimal basePrice =
                    product.getSellingPrice() != null ? product.getSellingPrice() : BigDecimal.ZERO;

            BigDecimal additionalPrice =
                    variant.getAdditionalPrice() != null ? variant.getAdditionalPrice() : BigDecimal.ZERO;

            BigDecimal unitPrice = basePrice.add(additionalPrice);

            BigDecimal itemTotal = unitPrice.multiply(BigDecimal.valueOf(cartItem.getQuantity()));

            CartItemDTO itemDTO = new CartItemDTO();

            itemDTO.setId(cartItem.getId());

            itemDTO.setProductId(product.getId());

            itemDTO.setVariantId(variant.getId());

            itemDTO.setProductName(product.getName());

            itemDTO.setImageUrl(product.getImageUrl());

            itemDTO.setColor(variant.getColor());

            itemDTO.setSize(variant.getSize());

            itemDTO.setQuantity(cartItem.getQuantity());

            itemDTO.setUnitPrice(unitPrice);

            itemDTO.setTotalPrice(itemTotal);

            cartItemDTOList.add(itemDTO);

            totalAmount = totalAmount.add(itemTotal);

            totalItems += cartItem.getQuantity();
        }

        response.setCartItems(cartItemDTOList);

        response.setTotalItems(totalItems);

        response.setTotalAmount(totalAmount);

        return response;
    }

    @Override
    public void removeItemsFromCart(UUID productId) {

        User customer = userService.getUserPrincipal();

        Cart cart = getCartByCustomerId(customer.getId());

        List<CartItem> cartItems = cartItemRepository.findAllByCartId(cart.getId());

        /*
         * REMOVE ALL ITEMS OF THIS PRODUCT
         */
        List<CartItem> itemsToRemove = cartItems
                .stream()
                .filter(item ->
                        item.getProduct() != null &&
                                item.getProduct().getId().equals(productId)
                )
                .toList();

        cartItems.removeAll(itemsToRemove);

        cartItemRepository.deleteAll(itemsToRemove);
    }

    @Override
    public void removeAllFromCart() {

        User customer = userService.getUserPrincipal();

        Cart cart = getCartByCustomerId(customer.getId());

        List<CartItem> cartItems = cartItemRepository.findAllByCartId(cart.getId());

        cartItemRepository.deleteAll(cartItems);

    }

    private Cart getCartByCustomerId(UUID customerId){
        return cartRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new BadRequestException(MyConstants
                        .ERR_MSG_NOT_FOUND + "Cart for customer with id: " + customerId));
    }

}
