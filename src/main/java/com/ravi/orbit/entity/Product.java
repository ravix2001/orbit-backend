package com.ravi.orbit.entity;

import com.ravi.orbit.enums.EStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "product_tbl")
public class Product extends UIDBase{

    private static final long serialVersionUID = 1L;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "features")
    private String features;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private EStatus status = EStatus.ACTIVE;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "market_price")
    private BigDecimal marketPrice;

    @Column(name = "discount_percent")
    private BigDecimal discountPercent;

    @Column(name = "discount_amount")
    private BigDecimal discountAmount;

    @Column(name = "selling_price")
    private BigDecimal sellingPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller", referencedColumnName = "id")
    private User seller;

    @Column(name = "seller_id", insertable = false, updatable = false)
    private UUID sellerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @Column(name = "category_id", insertable = false, updatable = false)
    private UUID categoryId;

}