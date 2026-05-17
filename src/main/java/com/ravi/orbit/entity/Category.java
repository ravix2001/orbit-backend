package com.ravi.orbit.entity;

import com.ravi.orbit.enums.EStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "category_tbl")
public class Category extends UIDBase {

    private static final long serialVersionUID = 1L;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private EStatus status = EStatus.ACTIVE;

    @Column(name = "image_url")
    private String imageUrl;

}