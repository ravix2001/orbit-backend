package com.ravi.orbit.service;

import com.ravi.orbit.dto.CartDTO;
import com.ravi.orbit.entity.Cart;

import java.util.List;

public interface ICartService {

    void addToCart(String username, Long productId);

    CartDTO getCartByUsername(String username);

    void removeFromCart(String username, Long productId);

    void removeAllFromCart(String username);

//    CartDTO handleCart(CartDTO cartDTO);
//
//    List<CartDTO> getAllCarts();
//
//    CartDTO getCartDTOById(Long id);
//
//    CartDTO getCartDTOByUserId(Long userId);

}
