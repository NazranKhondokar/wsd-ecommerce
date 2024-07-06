package com.wsd.ecommerce.service;

import com.wsd.ecommerce.projection.ProductDetailProjection;

import java.util.List;
import java.util.Map;

public interface ProductService {

    List<ProductDetailProjection> getTopItems();
}
