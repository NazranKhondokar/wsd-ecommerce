package com.wsd.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "shop_id")
    private Integer shopId;

    @Column(name = "invoice_no", length = 50)
    private String invoiceNo;

    @Column(name = "invoice_date")
    private LocalDate invoiceDate;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "delivery_address", columnDefinition = "TEXT")
    private String deliveryAddress;

    @Column(name = "payment_type")
    private Integer paymentType;

    @Column(name = "paid", precision = 30, scale = 6)
    private BigDecimal paid;

    @Column(name = "remain", precision = 30, scale = 6)
    private BigDecimal remain;

    @Column(name = "total_price", precision = 30, scale = 6)
    private BigDecimal totalPrice;

    @Column(name = "vat_amount", precision = 30, scale = 6)
    private BigDecimal vatAmount;

    @Column(name = "remarks", columnDefinition = "MEDIUMTEXT")
    private String remarks;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "modified_by")
    private Integer modifiedBy;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    @Column(name = "deleted", columnDefinition = "int default 0")
    private Integer deleted;

    @Column(name = "discount_code", length = 45)
    private String discountCode;

    @Column(name = "discount_amount", precision = 30, scale = 6)
    private BigDecimal discountAmount;

    @Column(name = "employee_status", length = 45)
    private String employeeStatus;

    @Column(name = "sales_order_id")
    private Integer salesOrderId;

    @Column(name = "gift_status")
    private Integer giftStatus;

    @Column(name = "gift_card_id", length = 45)
    private String giftCardId;
}

