package com.ravi.orbit.service;

import com.ravi.orbit.dto.CartDTO;

import java.util.UUID;

public interface ICartService {

    CartDTO addToCart(CartDTO cartDTO);

    CartDTO getMyCart();

    void removeItemsFromCart(UUID productId);

    void removeAllFromCart();

}
