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
public class ProductDTO {

    public ProductDTO(UUID id, String code, String name, String brand, EStatus status, String features, String description,
                      Integer quantity, BigDecimal marketPrice, BigDecimal discountPercent, BigDecimal discountAmount,
                      BigDecimal sellingPrice, UUID categoryId, String categoryName, UUID sellerId, String imageUrl) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.brand = brand;
        this.status = status;
        this.features = features;
        this.description = description;
        this.quantity = quantity;
        this.marketPrice = marketPrice;
        this.discountPercent = discountPercent;
        this.discountAmount = discountAmount;
        this.sellingPrice = sellingPrice;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.sellerId = sellerId;
        this.imageUrl = imageUrl;
    }

    public ProductDTO(UUID id, String name, String brand, String description, Integer quantity,
                      BigDecimal marketPrice, BigDecimal discountPercent, BigDecimal discountAmount,
                      BigDecimal sellingPrice, UUID categoryId, String categoryName, UUID sellerId, String imageUrl) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.quantity = quantity;
        this.marketPrice = marketPrice;
        this.discountPercent = discountPercent;
        this.discountAmount = discountAmount;
        this.sellingPrice = sellingPrice;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.sellerId = sellerId;
        this.imageUrl = imageUrl;
    }

    private UUID id;
    private String code;
    private String name;
    private String brand;
    private String features;
    private String description;
    private EStatus status;
    private Integer quantity;
    private BigDecimal marketPrice;
    private BigDecimal discountPercent;
    private BigDecimal discountAmount;
    private BigDecimal sellingPrice;
    private List<ColorDTO> colors;
    private List<SizeDTO> sizes;
    private String imageUrl;

    private UUID categoryId;
    private UUID sellerId;

    private String categoryName;
    private String sellerName;

}
