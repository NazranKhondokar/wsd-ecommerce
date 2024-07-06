package com.wsd.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "sales_details")
public class SalesDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sale_id")
    private Integer saleId;

    @Column(name = "inv_fg_stock_master_id")
    private Integer invFgStockMasterId;

    @Column(name = "inv_fg_stock_details_id")
    private Integer invFgStockDetailsId;

    @Column(name = "uom_id")
    private Integer uomId;

    @Column(name = "uom_name", length = 50)
    private String uomName;

    @Column(name = "rate", precision = 30, scale = 6)
    private BigDecimal rate;

    @Column(name = "qty", precision = 30, scale = 6)
    private BigDecimal qty;

    @Column(name = "total_price", precision = 30, scale = 6)
    private BigDecimal totalPrice;
}

