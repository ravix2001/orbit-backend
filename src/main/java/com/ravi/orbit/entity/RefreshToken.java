package com.ravi.orbit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "refresh_token_tbl")
public class RefreshToken extends UIDBase {

    private static final long serialVersionUID = 1L;

    @Column(name = "token", nullable = false, unique = true, length = 500)
    private String token;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "expiryDate", nullable = false)
    private LocalDateTime expiryDate;

}
