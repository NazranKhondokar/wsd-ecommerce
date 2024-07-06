package com.wsd.ecommerce.projection;

public interface CustomerWishProjection {
    Integer getCustomerWishId();
    String getBarcodeNo();
    Integer getProductDetailId();
    Integer getPrice();
    String getDescription();
    Integer getColor();
    Integer getProductSize();
    String getStockStatus();
}
