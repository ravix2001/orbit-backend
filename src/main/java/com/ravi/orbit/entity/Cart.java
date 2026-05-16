package com.ravi.orbit.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "cart_tbl")
public class Cart extends UIDBase {

    private static final long serialVersionUID = 1L;

//    @Column(name = "code", nullable = false, unique = true)
//    private String code;
//
//    @Column(name = "total_items")
//    private int totalItems;
//
//    @Column(name = "market_price")
//    private BigDecimal  marketPrice;
//
//    @Column(name = "discount_percent")
//    private BigDecimal discountPercent;
//
//    @Column(name = "discount_amount")
//    private BigDecimal discountAmount;
//
//    @Column(name = "selling_price")
//    private BigDecimal sellingPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private User customer;

    @Column(name = "customer_id", insertable = false, updatable = false)
    private UUID customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column(name = "product_id", insertable = false, updatable = false)
    private UUID productId;

}
