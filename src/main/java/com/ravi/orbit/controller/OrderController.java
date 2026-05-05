package com.ravi.orbit.controller;

import com.ravi.orbit.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final IOrderService orderService;

    @GetMapping("{userId}")
    public Object getOrdersByUserId(@PathVariable Long userId){
        return orderService.getOrdersByUserId(userId);
    }

}
