package com.ravi.orbit.service.impl;

import com.ravi.orbit.dto.CartDTO;
import com.ravi.orbit.entity.Cart;
import com.ravi.orbit.entity.User;
import com.ravi.orbit.exceptions.BadRequestException;
import com.ravi.orbit.repository.CartRepository;
import com.ravi.orbit.service.ICartService;
import com.ravi.orbit.service.IUserService;
import com.ravi.orbit.utils.CommonMethods;
import com.ravi.orbit.utils.MyConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements ICartService {

    private IUserService userService;

    private final CartRepository cartRepository;

    @Override
    public CartDTO handleCart(CartDTO cartDTO) {

        User user = userService.getUserById(cartDTO.getUserId());

        Cart cart = null;

        if (CommonMethods.isEmpty(cartDTO.getId())) {
            cart = new Cart();
            cart.setUser(user);
        }
        else{
            cart = getCartById(cartDTO.getId());
        }

        cart.setCode(cartDTO.getCode());
        cart.setTotalItems(cartDTO.getTotalItems());
        cart.setMarketPrice(cartDTO.getMarketPrice());
        cart.setDiscountPercent(cartDTO.getDiscountPercent());
        cart.setDiscountAmount(cartDTO.getDiscountAmount());
        cart.setSellingPrice(cartDTO.getSellingPrice());

        cartRepository.save(cart);

        cartDTO.setId(cart.getId());
        return cartDTO;
    }

    @Override
    public List<CartDTO> getAllCarts(){
        return cartRepository.getAllCarts();
    }

    // Todo
    @Override
    public void removeItemsFromCart(Long cartId, Long cartItemId){
        Cart cart = getCartById(cartId);
//        .................
    }

    @Override
    public void removeAllItemsFromCart(Long cartId){
        Cart cart = getCartById(cartId);
//        .................
    }

    @Override
    public CartDTO getCartDTOByUserId(Long userId) {
        return cartRepository.getCartByUserId(userId)
                .orElseThrow(() -> new BadRequestException(MyConstants.ERR_MSG_NOT_FOUND +
                        "Cart for user: " + userId));
    }

    @Override
    public CartDTO getCartDTOById(Long id) {
        return cartRepository.getCartById(id)
                .orElseThrow(() -> new BadRequestException(MyConstants.ERR_MSG_NOT_FOUND +
                        "Cart: " + id));
    }

    private Cart getCartById(Long id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(MyConstants.ERR_MSG_NOT_FOUND +
                        "Cart: " + id));
    }

}
