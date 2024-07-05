package com.wsd.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "sales_details")
public class SalesDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "sale_id")
    public Integer saleId;

    @Column(name = "inv_fg_stock_master_id")
    public Integer invFgStockMasterId;

    @Column(name = "inv_fg_stock_details_id")
    public Integer invFgStockDetailsId;

    @Column(name = "uom_id")
    public Integer uomId;

    @Column(name = "uom_name", length = 50)
    public String uomName;

    @Column(name = "rate", precision = 30, scale = 6)
    public BigDecimal rate;

    @Column(name = "qty", precision = 30, scale = 6)
    public BigDecimal qty;

    @Column(name = "total_price", precision = 30, scale = 6)
    public BigDecimal totalPrice;

    @Column(name = "created_by")
    public Integer createdBy;

    @Column(name = "modified_by")
    public Integer modifiedBy;

    @Column(name = "created")
    public LocalDateTime created;

    @Column(name = "modified")
    public LocalDateTime modified;

    @Column(name = "deleted", columnDefinition = "int not null default 0")
    public Integer deleted;
}

