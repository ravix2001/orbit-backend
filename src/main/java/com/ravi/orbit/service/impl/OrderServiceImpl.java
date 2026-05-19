package com.ravi.orbit.service.impl;

import com.ravi.orbit.dto.OrderDTO;
import com.ravi.orbit.dto.ProductDTO;
import com.ravi.orbit.dto.UserDTO;
import com.ravi.orbit.entity.Order;
import com.ravi.orbit.entity.Product;
import com.ravi.orbit.entity.User;
import com.ravi.orbit.enums.EOrderStatus;
import com.ravi.orbit.enums.EStatus;
import com.ravi.orbit.exceptions.BadRequestException;
import com.ravi.orbit.repository.OrderRepository;
import com.ravi.orbit.repository.ProductRepository;
import com.ravi.orbit.service.IOrderService;
import com.ravi.orbit.service.IProductService;
import com.ravi.orbit.service.IUserService;
import com.ravi.orbit.utils.MyConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements IOrderService {

    private final IUserService userService;
    private final IProductService productService;

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public Page<OrderDTO> getOrdersByCustomerId(UUID customerId, Pageable pageable){
        Page<OrderDTO> orderDTOs = orderRepository.getOrdersByCustomerId(customerId, pageable);
        for (OrderDTO orderDTO : orderDTOs) {
            orderDTO.setCustomer(userService.getUserDTOById(orderDTO.getCustomerId()));
            orderDTO.setSeller(userService.getUserDTOById(orderDTO.getSellerId()));
            orderDTO.setProduct(productService.getProduct(orderDTO.getProductId()));
        }
        return orderDTOs;
    }

    @Override
    public Page<OrderDTO> getOrdersBySellerId(UUID sellerId, Pageable pageable){
        return orderRepository.getOrdersBySellerId(sellerId, pageable);
    }

    @Override
    public OrderDTO createOrder(OrderDTO request, User customer) {

        Product product = productService.getProductById(request.getProductId());

        if (product == null) {
            throw new BadRequestException(MyConstants.ERR_MSG_NOT_FOUND + "Product: " + request.getProductId());
        }

        if (product.getStatus() != EStatus.ACTIVE) {
            throw new BadRequestException(MyConstants.ERR_MSG_NOT_ACTIVE + "Product: " + request.getProductId());
        }

        if (request.getTotalItems() <= 0) {
            throw new BadRequestException("Quantity must be greater than 0");
        }

        if (product.getQuantity() < request.getTotalItems()) {
            throw new BadRequestException("Insufficient quantity available");
        }

        User seller = product.getSeller();

        // =========================
        // PRICE CALCULATION
        // =========================

        BigDecimal quantity = BigDecimal.valueOf(request.getTotalItems());

        BigDecimal totalMarketPrice =
                product.getMarketPrice().multiply(quantity);

        BigDecimal totalSellingPrice =
                product.getSellingPrice().multiply(quantity);

        BigDecimal totalDiscount =
                totalMarketPrice.subtract(totalSellingPrice);

        // =========================
        // CREATE ORDER
        // =========================

        Order order = new Order();

        order.setCustomer(customer);
        order.setSeller(seller);
        order.setProduct(product);

        order.setOrderNumber(getOrderNumber());

        order.setTotalItems(request.getTotalItems());

        order.setTotalMarketPrice(totalMarketPrice);
        order.setTotalAmount(totalSellingPrice);
        order.setTotalDiscount(totalDiscount);

        order.setOrderStatus(
                request.getOrderStatus() != null
                        ? request.getOrderStatus()
                        : EOrderStatus.PLACED
        );

        // =========================
        // UPDATE PRODUCT STOCK
        // =========================

        product.setQuantity(
                product.getQuantity() - request.getTotalItems()
        );

        productRepository.save(product);

        orderRepository.save(order);

        // =========================
        // MAP RESPONSE
        // =========================

        request.setId(order.getId());

        request.setCustomer(userService.getUserDTOById(customer.getId()));

        request.setSeller(userService.getUserDTOById(seller.getId()));

        request.setProduct(productService.getProduct(product.getId()));

        request.setOrderNumber(order.getOrderNumber());

        request.setOrderStatus(order.getOrderStatus());

        request.setTotalItems(order.getTotalItems());
        request.setTotalMarketPrice(order.getTotalMarketPrice());
        request.setTotalAmount(order.getTotalAmount());
        request.setTotalDiscount(order.getTotalDiscount());

        request.setOrderDate(order.getOrderDate().toLocalDate());
        request.setDeliveryDate(order.getDeliveryDate().toLocalDate());

        return request;
    }

    public Long getOrderNumber() {
        Long maxOrderNumber = orderRepository.findMaxOrderNumber();

        if (maxOrderNumber == null) {
            return 1000L;
        } else {
            return maxOrderNumber + 1;
        }
    }


}
