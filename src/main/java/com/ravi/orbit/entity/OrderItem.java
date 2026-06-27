package com.ravi.orbit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "order_item_tbl")
public class OrderItem extends UIDBase {

    private static final long serialVersionUID = 1L;

    /*
     * ORDER
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "order_id", insertable = false, updatable = false)
    private UUID orderId;

    /*
     * PRODUCT
     */
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id")
//    private Product product;

    @Column(name = "product_id", nullable = false)
    private UUID productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_image")
    private String productImage;

    /*
     * VARIANT INFO
     */
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "variant_id")
//    private ProductVariant variant;

    @Column(name = "variant_id", nullable = false)
    private UUID variantId;

    /*
     * SELLER
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private User seller;

    @Column(name = "seller_id", insertable = false, updatable = false)
    private UUID sellerId;

    @Column(name = "seller_name")
    private String sellerName;

    @Column(name = "seller_phone")
    private String sellerPhone;

    @Column(name = "seller_image")
    private String sellerImage;

    /*
     * PRICING
     */
    @Column(name = "quantity")
    private Integer quantity = 1;

    @Column(name = "market_price", precision = 10, scale = 2)
    private BigDecimal marketPrice = BigDecimal.ZERO;

    @Column(name = "selling_price", precision = 10, scale = 2)
    private BigDecimal sellingPrice = BigDecimal.ZERO;

    @Column(name = "discount_amount", precision = 10, scale = 2)
    private BigDecimal discountAmount = BigDecimal.ZERO;

    @Column(name = "total_amount", precision = 10, scale = 2)
    private BigDecimal totalAmount = BigDecimal.ZERO;

}