package com.ravi.orbit.repository;

import com.ravi.orbit.dto.OrderDTO;
import com.ravi.orbit.entity.Order;
import com.ravi.orbit.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    @Query(" SELECT NEW com.ravi.orbit.dto.OrderDTO(o.id, o.orderNumber, o.totalItems, o.totalMarketPrice, " +
            " o.totalDiscount, o.totalSellingPrice, o.orderStatus, o.orderDate, o.deliveryDate ) " +
            " FROM Order o " +
            " WHERE o.customerId = :customerId ")
    Page<OrderDTO> getOrdersByCustomerId(UUID customerId, Pageable pageable);

    @Query(" SELECT NEW com.ravi.orbit.dto.OrderDTO(o.id, o.orderNumber, o.totalItems, o.totalMarketPrice, " +
            " o.totalDiscount, o.totalSellingPrice, o.orderStatus, o.orderDate, o.deliveryDate ) " +
            " FROM Order o " +
            " WHERE o.sellerId = :sellerId ")
    Page<OrderDTO> getOrdersBySellerId(UUID sellerId, Pageable pageable);

    @Query("SELECT MAX(o.orderNumber) FROM Order o")
    Long findMaxOrderNumber();

}
