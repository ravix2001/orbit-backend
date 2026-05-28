package com.ravi.orbit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartItemDTO {

    private UUID id;

    private UUID productId;

    private UUID variantId;

    private String productName;

    private String imageUrl;

    private String color;

    private String size;

    private Integer quantity;

    private BigDecimal unitPrice;

    private BigDecimal totalPrice;

}
