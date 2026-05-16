package com.ravi.orbit.repository;

import com.ravi.orbit.dto.CartDTO;
import com.ravi.orbit.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {

    Optional<Cart> findByCustomerIdAndProductId(UUID customerId, UUID productId);

    List<Cart> findAllByCustomerId(UUID customerId);

//    @Query(" SELECT NEW com.ravi.orbit.dto.CartDTO(c.id, c.code, c.totalItems, c.marketPrice, " +
//            " c.discountPercent, c.discountAmount, c.sellingPrice) " +
//            " FROM Cart c ")
//    List<CartDTO> getAllCarts();
//
//    @Query(" SELECT NEW com.ravi.orbit.dto.CartDTO(c.id, c.code, c.totalItems, c.marketPrice, " +
//            " c.discountPercent, c.discountAmount, c.sellingPrice) " +
//            " FROM Cart c " +
//            " WHERE c.id = :id ")
//    Optional<CartDTO> getCartById(Long id);
//
//    @Query(" SELECT NEW com.ravi.orbit.dto.CartDTO(c.id, c.code, c.totalItems, c.marketPrice, " +
//            " c.discountPercent, c.discountAmount, c.sellingPrice) " +
//            " FROM Cart c " +
//            " WHERE c.userId = :userId ")
//    Optional<CartDTO> getCartByUserId(Long userId);

}
