package com.ravi.orbit.entity;


import jakarta.persistence.Id;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PreUpdate;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@MappedSuperclass
public class UIDBase implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @UuidGenerator
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "created_datetime")
    protected LocalDateTime createdDateTime = LocalDateTime.now();

    @Column(name = "updated_datetime")
    protected LocalDateTime updatedDateTime;

    @PreUpdate
    protected void onUpdate() {
        this.updatedDateTime = LocalDateTime.now();
    }

}

