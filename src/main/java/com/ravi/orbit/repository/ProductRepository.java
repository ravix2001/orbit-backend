package com.ravi.orbit.repository;

import com.ravi.orbit.dto.ProductDTO;
import com.ravi.orbit.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query("SELECT NEW com.ravi.orbit.dto.ProductDTO(p.id, p.name, p.brand, p.description, p.quantity, " +
            "p.marketPrice, p.discountPercent, p.discountAmount, p.sellingPrice," +
            "p.categoryId, c.name, p.sellerId, p.imageUrl ) " +
            " FROM Product p" +
            " LEFT JOIN Category c ON p.categoryId = c.id " +
            " WHERE p.status = com.ravi.orbit.enums.EStatus.ACTIVE ")
    Page<ProductDTO> getAllProducts(Pageable pageable);

    @Query("SELECT NEW com.ravi.orbit.dto.ProductDTO(p.id, p.code, p.name, p.brand, p.status, p.features, " +
            "p.description, p.quantity, p.marketPrice, p.discountPercent, p.discountAmount, p.sellingPrice," +
            "p.categoryId, c.name, p.sellerId, p.imageUrl ) " +
            " FROM Product p" +
            " LEFT JOIN Category c ON p.categoryId = c.id " +
            " WHERE p.id = :id")
    Optional<ProductDTO> getProductDTOById(UUID id);

    @Query("SELECT NEW com.ravi.orbit.dto.ProductDTO(p.id, p.code, p.name, p.brand, p.status, p.features, " +
            "p.description, p.quantity, p.marketPrice, p.discountPercent, p.discountAmount, p.sellingPrice," +
            "p.categoryId, c.name, p.sellerId, p.imageUrl ) " +
            " FROM Product p" +
            " LEFT JOIN Category c ON p.categoryId = c.id " +
            " WHERE p.code = :code")
    Optional<ProductDTO> getProductDTOByCode(String code);

    @Query("SELECT NEW com.ravi.orbit.dto.ProductDTO(p.id, p.name, p.brand, p.description, p.quantity, " +
            "p.marketPrice, p.discountPercent, p.discountAmount, p.sellingPrice," +
            "p.categoryId, c.name, p.sellerId, p.imageUrl ) " +
            " FROM Product p" +
            " LEFT JOIN Category c ON p.categoryId = c.id " +
            " WHERE p.name = :name AND p.status = com.ravi.orbit.enums.EStatus.ACTIVE ")
    Page<ProductDTO> getProductDTOsByName(Pageable pageable, String name);

    @Query("SELECT NEW com.ravi.orbit.dto.ProductDTO(p.id, p.name, p.brand, p.description, p.quantity, " +
            "p.marketPrice, p.discountPercent, p.discountAmount, p.sellingPrice," +
            "p.categoryId, c.name, p.sellerId, p.imageUrl ) " +
            " FROM Product p" +
            " LEFT JOIN Category c ON p.categoryId = c.id " +
            " WHERE p.categoryId = :categoryId AND p.status = com.ravi.orbit.enums.EStatus.ACTIVE ")
    Page<ProductDTO> getProductDTOsByCategoryId(Pageable pageable, UUID categoryId);

    @Query("SELECT NEW com.ravi.orbit.dto.ProductDTO(p.id, p.name, p.brand, p.description, p.quantity, " +
            "p.marketPrice, p.discountPercent, p.discountAmount, p.sellingPrice," +
            "p.categoryId, c.name, p.sellerId, p.imageUrl ) " +
            " FROM Product p" +
            " LEFT JOIN Category c ON p.categoryId = c.id " +
            " WHERE p.sellerId = :sellerId AND p.status = com.ravi.orbit.enums.EStatus.ACTIVE ")
    Page<ProductDTO> getProductDTOsBySellerId(Pageable pageable, UUID sellerId);

}
