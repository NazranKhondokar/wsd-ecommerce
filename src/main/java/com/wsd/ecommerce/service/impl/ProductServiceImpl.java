package com.wsd.ecommerce.service.impl;

import com.wsd.ecommerce.projection.MaxSaleDayProjection;
import com.wsd.ecommerce.projection.ProductDetailProjection;
import com.wsd.ecommerce.repository.ProductDetailsRepository;
import com.wsd.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDetailsRepository productDetailsRepository;

    @Override
    public List<ProductDetailProjection> getTopItems() {
        return productDetailsRepository.getTopItems();
    }

    @Override
    public List<ProductDetailProjection> getLastMonthTopItems() {
        return productDetailsRepository.getLastMonthTopItems();
    }

    @Override
    public MaxSaleDayProjection getMaxSaleDay(String start, String end) {
        return productDetailsRepository.getMaxSaleDay(start, end);
    }
}
