package com.wsd.ecommerce.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "sales_order_details")
public class SalesOrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sale_order_id")
    private Integer saleOrderId;

    @Column(name = "inv_item_config_id")
    private Integer invItemConfigId;

    @Column(name = "item_name", length = 255)
    private String itemName;

    @Column(name = "finish_goods_no", length = 255)
    private String finishGoodsNo;

    @Column(name = "base_uom_id")
    private Integer baseUomId;

    @Column(name = "unit_price")
    private Integer unitPrice;

    @Column(name = "rate", precision = 30, scale = 6)
    private BigDecimal rate;

    @Column(name = "qty", precision = 30, scale = 6, columnDefinition = "decimal(30,6) default 0.000000")
    private BigDecimal qty;

    @Column(name = "total_value", precision = 30, scale = 6)
    private BigDecimal totalValue;

    @Column(name = "remarks", columnDefinition = "TEXT")
    private String remarks;

    @Column(name = "size_id", columnDefinition = "int default 0")
    private Integer sizeId;

    @Column(name = "color_id")
    private Integer colorId;
}
