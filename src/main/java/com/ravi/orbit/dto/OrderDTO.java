package com.ravi.orbit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ravi.orbit.enums.EOrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    public OrderDTO(UUID id, Long orderNumber, int totalItems, BigDecimal totalMarketPrice,
                    BigDecimal totalDiscount, BigDecimal totalAmount, EOrderStatus orderStatus,
                    LocalDateTime orderDate, LocalDateTime deliveryDate,
                    UUID customerId, String customerName, String customerPhone, String customerImage,
                    UUID sellerId, String sellerName, String sellerPhone, String sellerImage, UUID productId) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.totalItems = totalItems;
        this.totalMarketPrice = totalMarketPrice;
        this.totalDiscount = totalDiscount;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate.toLocalDate();
        this.deliveryDate = deliveryDate.toLocalDate();
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerImage = customerImage;
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.sellerPhone = sellerPhone;
        this.sellerImage = sellerImage;
        this.productId = productId;
    }

    private UUID id;

    private Long orderNumber;

    private int totalItems;

    private BigDecimal totalMarketPrice;

    private BigDecimal totalDiscount;

    private BigDecimal totalAmount;

    private EOrderStatus orderStatus;

//    @Embedded
//    private PaymentDetails paymentDetails = new PaymentDetails();

    private LocalDate orderDate;

    private LocalDate deliveryDate;

    private UUID customerId;

    private String customerName;

    private String customerPhone;

    private String customerImage;

    private UserDTO customer;

    private UUID sellerId;

    private String sellerName;

    private String sellerPhone;

    private String sellerImage;

    private UserDTO seller;

    private UUID productId;

    private ProductDTO product;

}
