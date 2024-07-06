package com.wsd.ecommerce.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "sales_order")
public class SalesOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sales_order_no", length = 55)
    private String salesOrderNo;

    @Column(name = "rasied_by")
    private Integer raisedBy;

    @Column(name = "rasied_for")
    private Integer raisedFor;

    @Column(name = "shop_id", columnDefinition = "int default 1")
    private Integer shopId;

    @Column(name = "total_value", precision = 30, scale = 6)
    private BigDecimal totalValue;

    @Column(name = "vat_amount", precision = 30, scale = 6, columnDefinition = "decimal(30,6) default 0.000000")
    private BigDecimal vatAmount;

    @Column(name = "discount_code", length = 45)
    private String discountCode;

    @Column(name = "discount_amount", precision = 30, scale = 6)
    private BigDecimal discountAmount;

    @Column(name = "discount_status", columnDefinition = "int default 0")
    private Integer discountStatus;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(name = "delivery_location", columnDefinition = "TEXT")
    private String deliveryLocation;

    @Column(name = "order_remarks", columnDefinition = "TEXT")
    private String orderRemarks;

    @Column(name = "status", columnDefinition = "int default 0")
    private Integer status;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "total_price", precision = 30, scale = 6)
    private BigDecimal totalPrice;

    @Column(name = "remain_amount", precision = 30, scale = 6, columnDefinition = "decimal(30,6) not null default 0.000000")
    private BigDecimal remainAmount;

    @Column(name = "employee_status")
    private Integer employeeStatus;

    @Column(name = "refund_status", columnDefinition = "int default 0")
    private Integer refundStatus;

    @Column(name = "refund_date", length = 45)
    private String refundDate;

    @Column(name = "sales_payment_status", length = 45)
    private String salesPaymentStatus;

    @Column(name = "gift_card_status")
    private Integer giftCardStatus;

    @Column(name = "gift_card_id", length = 45)
    private String giftCardId;
}

