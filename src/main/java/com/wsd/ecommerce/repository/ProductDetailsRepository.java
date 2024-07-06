package com.wsd.ecommerce.repository;

import com.wsd.ecommerce.entity.Product;
import com.wsd.ecommerce.entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer> {

}
