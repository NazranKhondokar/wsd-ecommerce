package com.wsd.ecommerce.repository;

import com.wsd.ecommerce.entity.CustomerWish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerWishRepository extends JpaRepository<CustomerWish, Integer> {

    @Query(value = """
            SELECT
                cw.*
            FROM
                customer_wish AS cw
            ORDER BY
                cw.id DESC
            """,
            countQuery = """
                    SELECT COUNT(cw.id) FROM customer_wish AS cw
                    """,
            nativeQuery = true)
    Page<CustomerWish> search(String search, Pageable pageable);
}
