package com.ravi.orbit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItemDTO {

    private UUID id;
    private String productName;
    private String productImage;
    private ProductVariantDTO variant;
    private int quantity;

    // Pricing
    private BigDecimal marketPrice;
    private BigDecimal sellingPrice;
    private BigDecimal discountAmount;
    private BigDecimal totalAmount;

    // Seller info
    private UUID sellerId;
    private String sellerName;
    private String sellerPhone;
    private String sellerImage;

}
