package com.ravi.orbit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ravi.orbit.entity.Cart;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartDTO {

    public CartDTO(Long id, String code, int totalItems, double marketPrice,
                   double discountPercent, double discountAmount, double sellingPrice) {
        this.id = id;
        this.code = code;
        this.totalItems = totalItems;
        this.marketPrice = marketPrice;
        this.discountPercent = discountPercent;
        this.discountAmount = discountAmount;
        this.sellingPrice = sellingPrice;
    }

    private Long id;

    private String code;

    private int totalItems;

    private double marketPrice;

    private double discountPercent;

    private double discountAmount;

    private double sellingPrice;

    private Long userId;

    private List<CartItemDTO> cartItems;

}
