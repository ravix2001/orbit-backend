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

    @Column(name = "size")
    private String size;

    @Column(name = "color")
    private String color;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column(name = "product_id", insertable = false, updatable = false)
    private UUID productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

    @Column(name = "cart_id", insertable = false, updatable = false)
    private UUID cartId;

}
