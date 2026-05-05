package com.ravi.orbit.repository;

import com.ravi.orbit.dto.OrderDTO;
import com.ravi.orbit.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(" SELECT NEW com.ravi.orbit.dto.OrderDTO(o.id, o.orderNumber, o.totalItems, o.totalMarketPrice, " +
            " o.totalDiscount, o.totalSellingPrice, o.orderStatus, o.orderDate, o.deliveryDate ) " +
            " FROM Order o " +
            " WHERE o.userId = :userId ")
    OrderDTO getOrdersByUserId(Long userId);

}
