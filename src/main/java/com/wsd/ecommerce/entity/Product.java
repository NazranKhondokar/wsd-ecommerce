package com.wsd.ecommerce.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "inv_fg_stock_master")
public class Product extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "inv_item_config_id")
    private Integer invItemConfigId;

    @Column(name = "shop_id")
    private Integer shopId;

    @Column(name = "fg_item_code", length = 55)
    private String fgItemCode;

    @Column(name = "item_description", columnDefinition = "TEXT")
    private String itemDescription;

    @Column(name = "stock_qty", precision = 30, scale = 6)
    private final BigDecimal stockQty = BigDecimal.ZERO;

    @Column(name = "remain_qty", precision = 30, scale = 6)
    private final BigDecimal remainQty = BigDecimal.ZERO;

    @Column(name = "sold_qty", precision = 30, scale = 6)
    private final BigDecimal soldQty = BigDecimal.ZERO;

    @Column(name = "issue_qty", precision = 30, scale = 6)
    private final BigDecimal issueQty = BigDecimal.ZERO;

    @Column(name = "production_cost", precision = 30, scale = 6)
    private final BigDecimal productionCost = BigDecimal.ZERO;

    @Column(name = "vat", precision = 30, scale = 6)
    private final BigDecimal vat = BigDecimal.ZERO;

    @Column(name = "price", precision = 30, scale = 6)
    private final BigDecimal price = BigDecimal.ZERO;

    @Column(name = "product_web_name", columnDefinition = "TEXT")
    private String productWebName;
}
