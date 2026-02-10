package com.ravi.orbit.service;

import com.ravi.orbit.dto.CartDTO;
import com.ravi.orbit.entity.Cart;

import java.util.List;

public interface ICartService {

    void addToCart(Long userId, Long productId);

    CartDTO getCartByUserId(Long userId);

    void removeFromCart(Long userId, Long productId);

    void removeAllFromCart(Long userId);

//    CartDTO handleCart(CartDTO cartDTO);
//
//    List<CartDTO> getAllCarts();
//
//    CartDTO getCartDTOById(Long id);
//
//    CartDTO getCartDTOByUserId(Long userId);

}
