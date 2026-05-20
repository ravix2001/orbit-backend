package com.ravi.orbit.service;

import com.ravi.orbit.dto.OrderDTO;
import com.ravi.orbit.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IOrderService {

    OrderDTO createOrder(OrderDTO request, User customer);

    OrderDTO getOrderById(UUID id);

    OrderDTO getOrderByOrderNumber(Long orderNumber);

    Page<OrderDTO> getOrdersByCustomerId(UUID customerId, Pageable pageable);

    Page<OrderDTO> getOrdersBySellerId(UUID sellerId, Pageable pageable);

}
