package com.wsd.ecommerce.validator;

import com.wsd.ecommerce.dto.CustomerWishDTO;
import com.wsd.ecommerce.entity.CustomerInfo;
import com.wsd.ecommerce.entity.CustomerWish;
import com.wsd.ecommerce.entity.Product;
import com.wsd.ecommerce.entity.ProductDetails;
import com.wsd.ecommerce.exception.CustomMessageException;
import com.wsd.ecommerce.repository.CustomerInfoRepository;
import com.wsd.ecommerce.repository.CustomerWishRepository;
import com.wsd.ecommerce.repository.ProductDetailsRepository;
import com.wsd.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomerWishValidator implements Validator {

    private final CustomerInfoRepository customerInfoRepository;
    private final ProductDetailsRepository productDetailsRepository;
    private final CustomerWishRepository customerWishRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerWishDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerWishDTO dto = (CustomerWishDTO) target;

        Optional<CustomerWish> customerWish = customerWishRepository.findByCustomerIdAndProductDetailId(dto.getCustomerId(), dto.getProductDetailId());
        if (customerWish.isPresent()) throw new CustomMessageException("Product already in wish list");

        Optional<ProductDetails> productDetails = productDetailsRepository.findById(dto.getProductDetailId());
        if (productDetails.isEmpty()) throw new CustomMessageException("Product not found to wish!");

        Optional<CustomerInfo> customerInfo = customerInfoRepository.findById(dto.getCustomerId());
        if (customerInfo.isEmpty()) throw new CustomMessageException("Customer not found!");
    }
}
