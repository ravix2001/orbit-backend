package com.ravi.orbit.entity;

import com.ravi.orbit.enums.EOrderStatus;
import com.ravi.orbit.enums.EStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "order_tbl")
public class Order extends UIDBase {

    private static final long serialVersionUID = 1L;

    @Column(name = "order_number")
    private Long orderNumber;

    @Column(name = "total_items")
    private int totalItems;

    @Column(name = "total_market_price")
    private double totalMarketPrice;

    @Column(name = "total_discount")
    private double totalDiscount;

    @Column(name = "total_selling_price")
    private double totalSellingPrice;

    @Column(name = "order_status")
    private EOrderStatus orderStatus = EOrderStatus.PENDING;

//    @Embedded
//    private PaymentDetails paymentDetails = new PaymentDetails();

    @Column(name = "order_date")
    private LocalDateTime orderDate = LocalDateTime.now();

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate = orderDate.plusDays(3);     // delivery date = 3 days of order date

    // Customer
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private User customer;

    @Column(name = "customer_id", insertable = false, updatable = false)
    private UUID customerId;

    // Seller
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private User seller;

    @Column(name = "seller_id", insertable = false, updatable = false)
    private UUID sellerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column(name = "product_id", insertable = false, updatable = false)
    private UUID productId;

}
