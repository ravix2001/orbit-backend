//package com.ravi.orbit.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.UUID;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "deal_tbl")
//public class Deal extends UIDBase {
//
//    private static final long serialVersionUID = 1L;
//
//    private double discount;
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
