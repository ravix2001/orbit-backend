package com.ravi.orbit.service.impl;

import com.ravi.orbit.dto.CartDTO;
import com.ravi.orbit.dto.ProductDTO;
import com.ravi.orbit.entity.Cart;
import com.ravi.orbit.entity.Product;
import com.ravi.orbit.entity.User;
import com.ravi.orbit.exceptions.BadRequestException;
import com.ravi.orbit.repository.CartRepository;
import com.ravi.orbit.service.ICartService;
import com.ravi.orbit.service.IProductService;
import com.ravi.orbit.service.IUserService;
import com.ravi.orbit.utils.MyConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public void addToCart(String username, UUID productId) {

        User customer = userService.getUserByUsername(username);
        Product product = productService.getProductById(productId);

        Optional<Cart> cart = cartRepository.findByCustomerIdAndProductId(customer.getId(), productId);
        if (cart.isEmpty()) {
            Cart newCart = new Cart();
            newCart.setCustomer(customer);
            newCart.setProduct(product);
            cartRepository.save(newCart);
        }
    }

    @Override
    public CartDTO getCartByUsername(String username) {

        User customer = userService.getUserByUsername(username);
        CartDTO cartDTO = new CartDTO();
        List<ProductDTO> products =  new ArrayList<>();

        List<Cart> allItems = cartRepository.findAllByCustomerId(customer.getId());
        for (Cart cart : allItems) {
            ProductDTO productDTO = productService.getProduct(cart.getProductId());
            products.add(productDTO);
        }

        cartDTO.setProducts(products);
        return cartDTO;
    }

    @Override
    public void removeFromCart(String username, UUID productId) {
        User customer = userService.getUserByUsername(username);
        Cart cart = getCartByUserIdAndProductId(customer.getId(), productId);
        cartRepository.delete(cart);
    }

    @Override
    public void removeAllFromCart(String username) {
        User customer = userService.getUserByUsername(username);
        List<Cart> allItems = cartRepository.findAllByCustomerId(customer.getId());
        cartRepository.deleteAll(allItems);
    }

//    @Override
//    public CartDTO handleCart(CartDTO cartDTO) {
//
//        User user = userService.getUserById(cartDTO.getUserId());
//
//        Cart cart = null;
//
//        if (CommonMethods.isEmpty(cartDTO.getId())) {
//            cart = new Cart();
//            cart.setUser(user);
//        }
//        else{
//            cart = getCartById(cartDTO.getId());
//        }
//
//        cart.setCode(cartDTO.getCode());
//        cart.setTotalItems(cartDTO.getTotalItems());
//        cart.setMarketPrice(cartDTO.getMarketPrice());
//        cart.setDiscountPercent(cartDTO.getDiscountPercent());
//        cart.setDiscountAmount(cartDTO.getDiscountAmount());
//        cart.setSellingPrice(cartDTO.getSellingPrice());
//
//        cartRepository.save(cart);
//
//        cartDTO.setId(cart.getId());
//        return cartDTO;
//    }
//
//    @Override
//    public List<CartDTO> getAllCarts(){
//        return cartRepository.getAllCarts();
//    }
//
//    @Override
//    public CartDTO getCartDTOByUserId(Long userId) {
//        return cartRepository.getCartByUserId(userId)
//                .orElseThrow(() -> new BadRequestException(MyConstants.ERR_MSG_NOT_FOUND +
//                        "Cart for user: " + userId));
//    }
//
//    @Override
//    public CartDTO getCartDTOById(Long id) {
//        return cartRepository.getCartById(id)
//                .orElseThrow(() -> new BadRequestException(MyConstants.ERR_MSG_NOT_FOUND +
//                        "Cart: " + id));
//    }
//
//    private Cart getCartById(Long id) {
//        return cartRepository.findById(id)
//                .orElseThrow(() -> new BadRequestException(MyConstants.ERR_MSG_NOT_FOUND +
//                        "Cart: " + id));
//    }

    private Cart getCartByUserIdAndProductId(UUID customerId, UUID productId) {
        return cartRepository.findByCustomerIdAndProductId(customerId, productId)
                .orElseThrow(() -> new BadRequestException(MyConstants.ERR_MSG_NOT_FOUND +
                        "Cart for customer: " + customerId + " and product: " + productId));
    }

}
