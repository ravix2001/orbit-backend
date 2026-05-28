package com.ravi.orbit.repository;

import com.ravi.orbit.dto.ProductVariantDTO;
import com.ravi.orbit.entity.ProductVariant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, UUID> {

    @Query(" SELECT NEW com.ravi.orbit.dto.ProductVariantDTO(v.id, v.color, v.size, v.quantity, v.isAvailable, " +
            " v.additionalPrice, v.sku) " +
            " FROM ProductVariant v " +
            " LEFT JOIN Product p ON v.productId = p.id " +
            " WHERE v.productId = :productId ")
    List<ProductVariantDTO> getProductVariantsByProductId(UUID productId);

    List<ProductVariant> findAllByProductId(UUID productId);

    @Query(" SELECT NEW com.ravi.orbit.dto.ProductVariantDTO(v.id, v.color, v.size, v.quantity, v.isAvailable, " +
            " v.additionalPrice, v.sku) " +
            " FROM ProductVariant v " +
            " WHERE v.id = :id ")
    Optional<ProductVariantDTO> getProductVariantById(UUID id);

    List<ProductVariant> findByIdAndProductId(UUID id, UUID productId);

    @Query("SELECT pv FROM ProductVariant pv WHERE pv.id IN :ids AND pv.productId = :productId")
    List<ProductVariant> findByIdsAndProductId(Set<UUID> ids, UUID productId);
}
