package com.wsd.ecommerce.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales_order_details")
public class SalesOrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "sale_order_id")
    public Integer saleOrderId;

    @Column(name = "inv_item_config_id")
    public Integer invItemConfigId;

    @Column(name = "item_name", length = 255)
    public String itemName;

    @Column(name = "finish_goods_no", length = 255)
    public String finishGoodsNo;

    @Column(name = "base_uom_id")
    public Integer baseUomId;

    @Column(name = "unit_price")
    public Integer unitPrice;

    @Column(name = "rate", precision = 30, scale = 6)
    public BigDecimal rate;

    @Column(name = "qty", precision = 30, scale = 6, columnDefinition = "decimal(30,6) default 0.000000")
    public BigDecimal qty;

    @Column(name = "total_value", precision = 30, scale = 6)
    public BigDecimal totalValue;

    @Column(name = "remarks", columnDefinition = "TEXT")
    public String remarks;

    @Column(name = "created_by")
    public Integer createdBy;

    @Column(name = "modified_by")
    public Integer modifiedBy;

    @Column(name = "created")
    public LocalDateTime created;

    @Column(name = "modified")
    public LocalDateTime modified;

    @Column(name = "deleted", columnDefinition = "int default 0")
    public Integer deleted;

    @Column(name = "size_id", columnDefinition = "int default 0")
    public Integer sizeId;

    @Column(name = "color_id")
    public Integer colorId;
}
