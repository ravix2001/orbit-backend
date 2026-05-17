package com.ravi.orbit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ColorDTO {

    public ColorDTO(UUID id, String color, boolean isAvailable, BigDecimal price, Integer quantity, UUID productId) {
        this.id = id;
        this.color = color;
        this.isAvailable = isAvailable;
        this.price = price;
        this.quantity = quantity;
        this.productId = productId;
    }

    private UUID id;

    private String color;

    private boolean isAvailable;

    private BigDecimal price;

    private Integer quantity;

    private UUID productId;

}
