package com.ravi.orbit.service.impl;

import com.ravi.orbit.dto.OrderDTO;
import com.ravi.orbit.entity.User;
import com.ravi.orbit.repository.OrderRepository;
import com.ravi.orbit.service.IOrderService;
import com.ravi.orbit.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final IUserService userService;

    private final OrderRepository orderRepository;

    @Override
    public OrderDTO getOrdersByUserId(Long userId){
        return orderRepository.getOrdersByUserId(userId);
    }

}
