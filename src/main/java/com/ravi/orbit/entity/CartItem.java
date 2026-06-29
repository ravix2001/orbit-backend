package com.ravi.orbit.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "cart_item_tbl")
public class CartItem extends UIDBase {

    private static final long serialVersionUID = 1L;

    @Column(name = "quantity")
    private int quantity = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

    @Column(name = "cart_id", insertable = false, updatable = false)
    private UUID cartId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id", referencedColumnName = "id")
//    private Product product;

    @Column(name = "product_id", nullable = false)
    private UUID productId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "variant_id")
//    private ProductVariant variant;

    @Column(name = "variant_id", nullable = false)
    private UUID variantId;

}
