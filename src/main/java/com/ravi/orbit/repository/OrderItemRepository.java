package com.ravi.orbit.repository;

import com.ravi.orbit.dto.OrderItemDTO;
import com.ravi.orbit.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {

    List<OrderItem> findAllByOrderId(UUID orderId);

//    @Query(" SELECT NEW com.ravi.orbit.dto.OrderItemDTO(o.id, o.orderNumber, o.totalItems, o.totalMarketPrice, " +
//            " o.totalDiscount, o.totalAmount, o.orderStatus, o.orderDate, o.deliveryDate, " +
//            " o.customerId, o.customerName, o.customerPhone, o.customerImage) " +
//            " FROM Order o " +
//            " WHERE o.id = :orderId ")
//    List<OrderItemDTO> getOrderItemsByOrderId(UUID orderId);

}
