package com.ravi.orbit.service.impl;

import com.ravi.orbit.dto.OrderDTO;
import com.ravi.orbit.dto.ProductDTO;
import com.ravi.orbit.dto.UserDTO;
import com.ravi.orbit.entity.Order;
import com.ravi.orbit.entity.Product;
import com.ravi.orbit.entity.User;
import com.ravi.orbit.repository.OrderRepository;
import com.ravi.orbit.service.IOrderService;
import com.ravi.orbit.service.IProductService;
import com.ravi.orbit.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final IUserService userService;
    private final IProductService productService;

    private final OrderRepository orderRepository;

    @Override
    public OrderDTO getOrdersByCustomerId(UUID customerId){
        return orderRepository.getOrdersByCustomerId(customerId);
    }

//    @Override
//    public OrderDTO createOrder(OrderDTO request){
//
//        User customer = userService.getUserPrincipal();
//        Product product = productService.getProductById(request.getProductId());
//        User seller = userService.getUserById(request.getSellerId());
//
//        Order order = new Order();
//        order.setCustomer(customer);
//        order.setProduct(product);
//        order.setSeller(seller);
//
//        orderRepository.save(order);
//
//        order.setOrderDate(request.getOrderDate());
//
//        OrderDTO orderDTO = getOrderDTO(order, customer, product, seller);
//        return ;
//    }

    private OrderDTO getOrderDTO(Order order, UserDTO customer, ProductDTO  product, UserDTO  seller){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setOrderNumber(order.getOrderNumber());
        orderDTO.setTotalItems(order.getTotalItems());
        orderDTO.setTotalMarketPrice(order.getTotalMarketPrice());
        orderDTO.setTotalDiscount(order.getTotalDiscount());
        orderDTO.setTotalSellingPrice(order.getTotalSellingPrice());
        orderDTO.setOrderStatus(order.getOrderStatus());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setDeliveryDate(order.getDeliveryDate());
        orderDTO.setCustomer(customer);
        orderDTO.setProduct(product);
        orderDTO.setSeller(seller);
        return orderDTO;
    }


}
