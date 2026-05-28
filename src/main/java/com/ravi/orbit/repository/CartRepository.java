package com.ravi.orbit.repository;

import com.ravi.orbit.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {

    Optional<Cart> findByCustomerId(UUID customerId);

//    @Query("""
//    SELECT DISTINCT c
//    FROM Cart c
//    LEFT JOIN FETCH CartItem ci ON ci.cartId = c.id
//    LEFT JOIN FETCH ci.product
//    LEFT JOIN FETCH ci.variant
//    WHERE c.customerId = :customerId
//    """)
//    Optional<Cart> findDetailedCartByCustomerId(UUID customerId);

}
