package com.ravi.orbit.service;

import com.ravi.orbit.dto.CartDTO;

import java.util.List;

public interface ICartService {

    CartDTO handleCart(CartDTO cartDTO);

    List<CartDTO> getAllCarts();

    CartDTO getCartDTOById(Long id);

    CartDTO getCartDTOByUserId(Long userId);

    void removeItemsFromCart(Long cartId, Long cartItemId);

    void removeAllItemsFromCart(Long cartId);

}
