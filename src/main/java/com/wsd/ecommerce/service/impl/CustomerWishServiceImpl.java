package com.wsd.ecommerce.service.impl;

import com.wsd.ecommerce.dto.CustomerWishDTO;
import com.wsd.ecommerce.entity.CustomerWish;
import com.wsd.ecommerce.repository.CustomerWishRepository;
import com.wsd.ecommerce.service.CustomerWishService;
import com.wsd.ecommerce.util.ServiceHelper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerWishServiceImpl implements CustomerWishService {

    private final CustomerWishRepository repository;

    @Transactional
    public CustomerWish save(CustomerWishDTO dto) {
        CustomerWish customerWish = dto.to();
        return repository.save(customerWish);
    }

    @Transactional
    public CustomerWish update(CustomerWish customerWish, CustomerWishDTO dto) {
        dto.update(customerWish);
        return repository.save(customerWish);
    }

    public Map<String, Object> search(Integer page, Integer size, String sortBy, String search) {
        ServiceHelper<CustomerWish> serviceHelper = new ServiceHelper<>(CustomerWish.class);
        return serviceHelper.getList(
                repository.search(search, serviceHelper.getPageable(sortBy, page, size)),
                page, size);
    }

    public Optional<CustomerWish> findById(Integer entityId) {
        return repository.findById(entityId);
    }

    @Transactional
    public void delete(CustomerWish customerWish) {
        repository.delete(customerWish);
    }

    @Transactional
    public CustomerWish updateRecordStatus(CustomerWish customerWish) {
        return repository.save(customerWish);
    }

    @Transactional
    public CustomerWish updateTaskCompletionStatus(CustomerWish customerWish) {
        return repository.save(customerWish);
    }
}
