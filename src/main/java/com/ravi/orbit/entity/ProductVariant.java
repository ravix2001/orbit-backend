package com.ravi.orbit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "product_variant_tbl")
public class ProductVariant extends UIDBase {

    private static final long serialVersionUID = 1L;

    /*
     * PRODUCT
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column(name = "product_id", insertable = false, updatable = false)
    private UUID productId;

    /*
     * VARIANTS
     */
    @Column(name = "color")
    private String color;

    @Column(name = "size")
    private String size;

    /*
     * INVENTORY
     */
    @Column(name = "quantity")
    private Integer quantity = 0;

    @Column(name = "is_available")
    private Boolean isAvailable = true;

    /*
     * PRICING
     */
    @Column(name = "additional_price", precision = 10, scale = 2)
    private BigDecimal additionalPrice = BigDecimal.ZERO;

//    @Column(name = "market_price", precision = 10, scale = 2)
//    private BigDecimal marketPrice = BigDecimal.ZERO;
//
//    @Column(name = "selling_price", precision = 10, scale = 2)
//    private BigDecimal sellingPrice = BigDecimal.ZERO;
//
//    @Column(name = "discount_percent", precision = 10, scale = 2)
//    private BigDecimal discountPercent = BigDecimal.ZERO;
//
//    @Column(name = "discount_amount", precision = 10, scale = 2)
//    private BigDecimal discountAmount = BigDecimal.ZERO;

    /*
     * SKU = Stock Keeping Unit
     * WJ-1234-M-RED
     * WJ = brand
     * 1234 = product code
     * M = medium size
     * RED = color
     */
    @Column(name = "sku", unique = true)
    private String sku;
}