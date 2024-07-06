package com.wsd.ecommerce.service;

import com.wsd.ecommerce.projection.MaxSaleDayProjection;
import com.wsd.ecommerce.projection.ProductDetailProjection;

import java.util.List;
import java.util.Map;

public interface ProductService {

    List<ProductDetailProjection> getTopItems();
    List<ProductDetailProjection> getLastMonthTopItems();
    MaxSaleDayProjection getMaxSaleDay(String start, String end);
}
