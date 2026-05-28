package com.ravi.orbit.repository;

import com.ravi.orbit.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CartItemRepository extends JpaRepository<CartItem, UUID> {

    Optional<CartItem> findByCartIdAndVariantId(UUID cartId, UUID variantId);

    List<CartItem> findAllByCartId(UUID cartId);

    void deleteByCartId(UUID cartId);
}
