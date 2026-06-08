package com.ravi.orbit.repository;

import com.ravi.orbit.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, UUID> {

    Optional<RefreshToken> findByToken(String token);

    Optional<RefreshToken> findByTokenAndRevokedFalse(String token);

    void deleteByToken(String token);

    void deleteByUsername(String username);

    void deleteAllByUsername(String username);

}

