package com.wsd.ecommerce.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales_order")
public class SalesOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "sales_order_no", length = 55)
    public String salesOrderNo;

    @Column(name = "rasied_by")
    public Integer raisedBy;

    @Column(name = "rasied_for")
    public Integer raisedFor;

    @Column(name = "shop_id", columnDefinition = "int default 1")
    public Integer shopId;

    @Column(name = "total_value", precision = 30, scale = 6)
    public BigDecimal totalValue;

    @Column(name = "vat_amount", precision = 30, scale = 6, columnDefinition = "decimal(30,6) default 0.000000")
    public BigDecimal vatAmount;

    @Column(name = "discount_code", length = 45)
    public String discountCode;

    @Column(name = "discount_amount", precision = 30, scale = 6)
    public BigDecimal discountAmount;

    @Column(name = "discount_status", columnDefinition = "int default 0")
    public Integer discountStatus;

    @Column(name = "delivery_date")
    public LocalDate deliveryDate;

    @Column(name = "delivery_location", columnDefinition = "TEXT")
    public String deliveryLocation;

    @Column(name = "order_remarks", columnDefinition = "TEXT")
    public String orderRemarks;

    @Column(name = "status", columnDefinition = "int default 0")
    public Integer status;

    @Column(name = "customer_id")
    public Integer customerId;

    @Column(name = "total_price", precision = 30, scale = 6)
    public BigDecimal totalPrice;

    @Column(name = "remain_amount", precision = 30, scale = 6, columnDefinition = "decimal(30,6) not null default 0.000000")
    public BigDecimal remainAmount;

    @Column(name = "employee_status")
    public Integer employeeStatus;

    @Column(name = "refund_status", columnDefinition = "int default 0")
    public Integer refundStatus;

    @Column(name = "refund_date", length = 45)
    public String refundDate;

    @Column(name = "sales_payment_status", length = 45)
    public String salesPaymentStatus;

    @Column(name = "gift_card_status")
    public Integer giftCardStatus;

    @Column(name = "gift_card_id", length = 45)
    public String giftCardId;
}

