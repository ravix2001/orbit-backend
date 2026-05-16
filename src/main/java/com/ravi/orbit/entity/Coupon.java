//package com.ravi.orbit.entity;
//
//import com.ravi.orbit.enums.EStatus;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.time.LocalDateTime;
//import java.util.UUID;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "coupon_tbl")
//public class Coupon extends UIDBase {
//
//    private static final long serialVersionUID = 1L;
//
//    private String code;
//
//    private String description;
//
//    private double discount;
//
//    private LocalDateTime validityStartDate;
//
//    private LocalDateTime validityExpiryDate;
//
//    private double minimumOrderAmount;
//
//    private double maximumOrderAmount;
//
//    private EStatus status;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id", referencedColumnName = "id")
//    private Product product;
//
//    @Column(name = "product_id", insertable = false, updatable = false)
//    private UUID productId;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id", referencedColumnName = "id")
//    private User customer;
//
//    @Column(name = "customer_id", insertable = false, updatable = false)
//    private UUID customerId;
//
//}
