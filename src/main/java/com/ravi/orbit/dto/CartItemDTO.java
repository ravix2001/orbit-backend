package com.ravi.orbit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ravi.orbit.entity.Product;
import lombok.*;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartItemDTO {

    private Long id;

    private int quantity = 1;

    private String size;

    private String color;

    private Product product;

}
