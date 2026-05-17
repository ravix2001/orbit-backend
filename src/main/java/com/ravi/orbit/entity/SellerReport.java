//package com.ravi.orbit.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "seller_report_tbl")
//public class SellerReport extends UIDBase {
//
//    private static final long serialVersionUID = 1L;
//
//    private int totalOrders = 0;
//
//    private int cancelledOrders = 0;
//
//    private int totalTransactions = 0;
//
//    private double totalSales = 0;
//
//    private double totalRefunds = 0;
//
//    private double totalRevenue = 0;
//
//    private double totalTax = 0;
//
//    private double netRevenue = 0;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "seller_id", referencedColumnName = "id")
//    private User seller;
//
//    @Column(name = "seller_id", insertable = false, updatable = false)
//    private String sellerId;
//
//}
