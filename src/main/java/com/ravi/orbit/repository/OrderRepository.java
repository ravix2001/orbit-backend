package com.ravi.orbit.repository;

import com.ravi.orbit.dto.OrderDTO;
import com.ravi.orbit.entity.Order;
import com.ravi.orbit.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    @Query(" SELECT NEW com.ravi.orbit.dto.OrderDTO(o.id, o.orderNumber, o.totalItems, o.totalMarketPrice, " +
            " o.totalDiscount, o.totalSellingPrice, o.orderStatus, o.orderDate, o.deliveryDate ) " +
            " FROM Order o " +
            " WHERE o.customerId = :customerId ")
    OrderDTO getOrdersByCustomerId(UUID customerId);

    @Query(" SELECT NEW com.ravi.orbit.dto.OrderDTO(o.id, o.orderNumber, o.totalItems, o.totalMarketPrice, " +
            " o.totalDiscount, o.totalSellingPrice, o.orderStatus, o.orderDate, o.deliveryDate ) " +
            " FROM Order o " +
            " WHERE o.sellerId = :sellerId ")
    OrderDTO getOrdersBySellerId(UUID sellerId);

    List<Order> customer(User customer);
}
