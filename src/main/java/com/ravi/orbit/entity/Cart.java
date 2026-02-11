package com.ravi.orbit.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column(name = "product_id", insertable = false, updatable = false)
    private Long productId;

}
