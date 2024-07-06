package com.wsd.ecommerce.projection;

public interface ProductDetailProjection {
    String getBarcodeNo();
    Integer getProductDetailId();
    Integer getPrice();
    String getDescription();
    Integer getColor();
    Integer getProductSize();
    String getStockStatus();
}
