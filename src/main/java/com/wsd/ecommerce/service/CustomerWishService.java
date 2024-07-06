package com.wsd.ecommerce.service;

import com.wsd.ecommerce.dto.CustomerWishDTO;
import com.wsd.ecommerce.entity.CustomerWish;
import jakarta.transaction.Transactional;

import java.util.Map;
import java.util.Optional;

public interface CustomerWishService {

    @Transactional
    CustomerWish save(CustomerWishDTO dto);

    @Transactional
    CustomerWish update(CustomerWish customerWish, CustomerWishDTO dto);

    Map<String, Object> search(Integer page, Integer size, String sortBy, String search);

    Optional<CustomerWish> findById(Integer entityId);

    @Transactional
    void delete(CustomerWish customerWish);

    @Transactional
    CustomerWish updateRecordStatus(CustomerWish customerWish);

    @Transactional
    CustomerWish updateTaskCompletionStatus(CustomerWish customerWish);
}
