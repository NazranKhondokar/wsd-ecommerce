package com.wsd.ecommerce.repository;

import com.wsd.ecommerce.entity.CustomerWish;
import com.wsd.ecommerce.projection.CustomerWishProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerWishRepository extends JpaRepository<CustomerWish, Integer> {

    Optional<CustomerWish> findByCustomerIdAndProductDetailId(Integer customerId, Integer productId);

    @Query(value = """
            SELECT
            	cw.id AS customerWishId,
            	cw.customer_id AS customerId,
            	ifsd.barcode_no AS barcodeNo,
            	ifsd.id AS productDetailId,
            	ifsd.price AS price,
            	ifsd.item_description AS description,
            	ifsd.color AS color,
            	ifsd.`size` AS productSize,
            	ifsd.stock_status AS stockStatus
            FROM wsd.customer_wish cw
            LEFT JOIN inv_fg_stock_details ifsd ON
            	ifsd.id = cw.product_detail_id
            WHERE
            	:customerId IS NULL OR cw.customer_id = :customerId
            ORDER BY
                cw.id DESC
            """,
            countQuery = """
                    SELECT COUNT(cw.id) FROM customer_wish AS cw
                    FROM wsd.customer_wish cw
                    LEFT JOIN inv_fg_stock_details ifsd ON
                        ifsd.id = cw.product_detail_id
                    WHERE
                        :customerId IS NULL OR cw.customer_id = :customerId
                    """,
            nativeQuery = true)
    Page<CustomerWishProjection> search(Integer customerId, Pageable pageable);
}
