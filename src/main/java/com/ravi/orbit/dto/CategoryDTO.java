package com.ravi.orbit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ravi.orbit.enums.EStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {

    public CategoryDTO(UUID id, String name, EStatus status, String imageUrl) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.imageUrl = imageUrl;
    }

    private UUID id;

    private String name;

    private EStatus status;

    private String imageUrl;

    private List<ProductDTO> products;

}
