//package com.ravi.orbit.entity;
//
//import com.ravi.orbit.enums.EPaymentMethod;
//import com.ravi.orbit.enums.EPaymentStatus;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.UUID;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "transaction_tbl")
//public class Transaction extends UIDBase {
//
//    private static final long serialVersionUID = 1L;
//
//    private String transactionId;
//
//    private LocalDateTime transactionDate;
//
//    private BigDecimal amount;
//
//    private EPaymentMethod paymentMethod;
//
//    private EPaymentStatus status = EPaymentStatus.PENDING;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id", referencedColumnName = "id")
//    private Order order;
//
//    @Column(name = "order_id", insertable = false, updatable = false)
//    private String orderId;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id", referencedColumnName = "id")
//    private User customer;
//
//    @Column(name = "customer_id", insertable = false, updatable = false)
//    private UUID customerId;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "seller_id", referencedColumnName = "id")
//    private User seller;
//
//    @Column(name = "seller_id", insertable = false, updatable = false)
//    private UUID sellerId;
//
//
//}
