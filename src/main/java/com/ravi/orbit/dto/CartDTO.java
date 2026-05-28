package com.ravi.orbit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartDTO {

    private UUID id;

    private UUID variantId;

    private Integer quantity;

    private Integer totalItems;

    private BigDecimal totalAmount;

    private List<CartItemDTO> cartItems;

}
