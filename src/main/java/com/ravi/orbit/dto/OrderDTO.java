package com.ravi.orbit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ravi.orbit.enums.EOrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    public OrderDTO(Long id, Long orderNumber, int totalItems, double totalMarketPrice,
                    double totalDiscount, double totalSellingPrice, EOrderStatus orderStatus,
                    LocalDateTime orderDate, LocalDateTime deliveryDate) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.totalItems = totalItems;
        this.totalMarketPrice = totalMarketPrice;
        this.totalDiscount = totalDiscount;
        this.totalSellingPrice = totalSellingPrice;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }

    private Long id;

    private Long orderNumber;

    private int totalItems;

    private double totalMarketPrice;

    private double totalDiscount;

    private double totalSellingPrice;

    private EOrderStatus orderStatus;

//    @Embedded
//    private PaymentDetails paymentDetails = new PaymentDetails();

    private LocalDateTime orderDate;

    private LocalDateTime deliveryDate;

    private Long userId;

    private Long sellerId;

    private Long productId;

}
