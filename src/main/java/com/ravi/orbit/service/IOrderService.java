package com.ravi.orbit.service;

import com.ravi.orbit.dto.OrderDTO;

import java.util.UUID;

public interface IOrderService {

    OrderDTO getOrdersByCustomerId(UUID userId);

//    OrderDTO createOrder(OrderDTO request);

}
