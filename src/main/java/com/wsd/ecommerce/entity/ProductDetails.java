package com.wsd.ecommerce.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "inv_fg_stock_details")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "inv_fg_stock_master_id")
    private Integer invFgStockMasterId;

    @Column(name = "sales_order_details_id")
    private Integer salesOrderDetailsId;

    @Column(name = "shop_id")
    private Integer shopId;

    @Column(name = "barcode_no", length = 255)
    private String barcodeNo;

    @Column(name = "finished_goods_no", length = 255)
    private String finishedGoodsNo;

    @Column(name = "third_party")
    private Integer thirdParty;

    @Column(name = "order_qty", precision = 30, scale = 6)
    private final BigDecimal orderQty = BigDecimal.ZERO;

    @Column(name = "remain_qty", precision = 30, scale = 6)
    private final BigDecimal remainQty = BigDecimal.ZERO;

    @Column(name = "issue_qty", precision = 30, scale = 6)
    private final BigDecimal issueQty = BigDecimal.ZERO;

    @Column(name = "sold_qty", precision = 30, scale = 6)
    private final BigDecimal soldQty = BigDecimal.ZERO;

    @Column(name = "stock_qty", precision = 30, scale = 6)
    private final BigDecimal stockQty = BigDecimal.ZERO;

    @Column(name = "uom_id")
    private Integer uomId;

    @Column(name = "prodcution_cost", precision = 30, scale = 6)
    private final BigDecimal productionCost = BigDecimal.ZERO;

    @Column(name = "vat", precision = 30, scale = 6)
    private final BigDecimal vat = BigDecimal.ZERO;

    @Column(name = "price", precision = 30, scale = 6)
    private final BigDecimal price = BigDecimal.ZERO;

    @Column(name = "item_description", columnDefinition = "TEXT")
    private String itemDescription;

    @Column(name = "color")
    private Integer color;

    @Column(name = "size")
    private Integer size;

    @Column(name = "product_web_name", columnDefinition = "TEXT")
    private String productWebName;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "modified_by")
    private Integer modifiedBy;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    @Column(name = "deleted")
    private final Integer deleted = 0;

    @Column(name = "image", length = 255)
    private String image;

    @Column(name = "previous_product_code", length = 45)
    private String previousProductCode;

    @Column(name = "stock_status", length = 45)
    private final String stockStatus = "";
}

