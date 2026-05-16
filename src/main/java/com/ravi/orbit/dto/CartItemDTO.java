package com.ravi.orbit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ravi.orbit.entity.Product;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartItemDTO {

    private UUID id;

    private int quantity = 1;

    private String size;

    private String color;

    private Product product;

}
