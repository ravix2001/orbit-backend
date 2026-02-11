package com.ravi.orbit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ravi.orbit.entity.Cart;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartDTO {

//    public CartDTO(Long id, String code, int totalItems, BigDecimal marketPrice,
//                   BigDecimal discountPercent, BigDecimal discountAmount, BigDecimal sellingPrice) {
//        this.id = id;
//        this.code = code;
//        this.totalItems = totalItems;
//        this.marketPrice = marketPrice;
//        this.discountPercent = discountPercent;
//        this.discountAmount = discountAmount;
//        this.sellingPrice = sellingPrice;
//    }

    private Long id;

    private Long userId;

    private Long productId;

    private int totalItems;

    private BigDecimal marketPrice;

    private BigDecimal discountPercent;

    private BigDecimal discountAmount;

    private BigDecimal sellingPrice;

    private List<ProductDTO> products;

}
