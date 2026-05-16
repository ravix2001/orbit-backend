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
//@Table(name = "order_item_tbl")
//public class OrderItem extends UIDBase {
//
//    private static final long serialVersionUID = 1L;
//
//    private String size;
//
//    private int quantity;
//
//    private double marketPrice;
//
//    private double sellingPrice;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id", referencedColumnName = "id")
//    private Product product;
//
//    @Column(name = "product_id", insertable = false, updatable = false)
//    private UUID productId;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id", referencedColumnName = "id")
//    private Order order;
//
//    @Column(name = "order_id", insertable = false, updatable = false)
//    private UUID orderId;
//
//}
