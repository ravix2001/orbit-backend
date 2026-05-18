package com.ravi.orbit.service;

import com.ravi.orbit.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IOrderService {

    Page<OrderDTO> getOrdersByCustomerId(UUID customerId, Pageable pageable);

    Page<OrderDTO> getOrdersBySellerId(UUID sellerId, Pageable pageable);

//    OrderDTO createOrder(OrderDTO request);

}
