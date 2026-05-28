package com.ravi.orbit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ravi.orbit.enums.EStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductVariantDTO {

    public ProductVariantDTO(UUID id, String color, String size, Integer quantity, Boolean isAvailable,
                             BigDecimal additionalPrice, String sku) {
        this.id = id;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
        this.isAvailable = isAvailable;
        this.additionalPrice = additionalPrice;
        this.sku = sku;
    }

    private UUID id;

    private String color;

    private String size;

    private Integer quantity;

    private Boolean isAvailable;

    private BigDecimal additionalPrice;

    private String sku;

}
