package com.ravi.orbit.controller;

import com.ravi.orbit.dto.OrderDTO;
import com.ravi.orbit.entity.User;
import com.ravi.orbit.service.IOrderService;
import com.ravi.orbit.service.IUserService;
import com.ravi.orbit.utils.CommonMethods;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final IOrderService orderService;

    private final IUserService userService;

    @PostMapping("/createOrder")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok(orderService.createOrder(orderDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable UUID id){
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    @GetMapping(params = "orderNumber")
    public ResponseEntity<OrderDTO> getOrderById(@RequestParam Long orderNumber){
        return ResponseEntity.ok(orderService.getOrderByOrderNumber(orderNumber));
    }

    @GetMapping(params = "customerId")
    public ResponseEntity<Page<OrderDTO>> getOrdersByCustomer(
            @RequestParam UUID customerId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean ascending){

        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);

        return ResponseEntity.ok(orderService.getOrdersByCustomerId(customerId, pageable));
    }

    @GetMapping(params = "sellerId")
    public ResponseEntity<Page<OrderDTO>> getOrdersBySeller(
            @RequestParam UUID sellerId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size,
//            @RequestParam(defaultValue = "orderNumber") String sortBy,
            @RequestParam(defaultValue = "true") boolean ascending){

//        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size);

        return ResponseEntity.ok(orderService.getOrdersBySellerId(sellerId, pageable));
    }

    @PutMapping("/confirm/{orderId}")
    public ResponseEntity<?> confirmOrder(@PathVariable UUID orderId){
        orderService.confirmOrder(orderId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/cancel/{orderId}")
    public ResponseEntity<?> cancelOrder(@PathVariable UUID orderId){
        orderService.cancelOrder(orderId);
        return ResponseEntity.ok().build();
    }

}
