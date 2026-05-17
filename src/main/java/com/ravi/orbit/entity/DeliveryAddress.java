//package com.ravi.orbit.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.UUID;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "delivery_address_tbl")
//public class DeliveryAddress extends UIDBase {
//
//    private static final long serialVersionUID = 1L;
//
//    private String name;
//
//    private String landmark;
//
//    private String street;
//
//    private String tole;
//
//    private String city;
//
//    private String state;
//
//    private String country;
//
//    private String zipcode;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id", referencedColumnName = "id")
//    private User customer;
//
//    @Column(name = "customer_id", insertable = false, updatable = false)
//    private UUID customerId;
//
//}
