package com.ravi.orbit.service;

import com.ravi.orbit.dto.CartDTO;
import com.ravi.orbit.entity.Cart;

import java.util.List;
import java.util.UUID;

public interface ICartService {

    void addToCart(String username, UUID productId);

    CartDTO getCartByUsername(String username);

    void removeFromCart(String username, UUID productId);

    void removeAllFromCart(String username);

//    CartDTO handleCart(CartDTO cartDTO);
//
//    List<CartDTO> getAllCarts();
//
//    CartDTO getCartDTOById(UUID id);
//
//    CartDTO getCartDTOByUserId(UUID userId);

}
