package com.ravi.orbit.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ravi.orbit.enums.EStatus;
import com.ravi.orbit.enums.EGender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "user_tbl")
public class User extends UIDBase {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private EGender gender;

    @Column(name = "dob")
    private LocalDate dob;

    // status
    @Enumerated(EnumType.STRING)
    @Column(name = "user_status")
    private EStatus status = EStatus.ACTIVE;

    @Column(name = "image_url")
    private String imageUrl;

    // address
    @Column(name = "address")
    private String address;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "state")
    private String state;

    @Column(name = "country_code")
    private String countryCode;

}
