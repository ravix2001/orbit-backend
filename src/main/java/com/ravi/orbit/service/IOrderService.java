package com.ravi.orbit.service;

import com.ravi.orbit.dto.OrderDTO;

public interface IOrderService {

    OrderDTO getOrdersByUserId(Long userId);

}
