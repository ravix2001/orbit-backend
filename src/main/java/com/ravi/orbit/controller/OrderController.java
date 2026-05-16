package com.ravi.orbit.controller;

import com.ravi.orbit.dto.OrderDTO;
import com.ravi.orbit.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final IOrderService orderService;

    @GetMapping("{userId}")
    public ResponseEntity<OrderDTO> getOrdersByCustomerId(@PathVariable UUID customerId){
        return ResponseEntity.ok(orderService.getOrdersByCustomerId(customerId));
    }

//    @PostMapping("/createOrder")
//    public Object createOrder(@RequestBody OrderDTO orderDTO){
//        return ResponseEntity.ok(orderService.createOrder(orderDTO));
//    }

}
