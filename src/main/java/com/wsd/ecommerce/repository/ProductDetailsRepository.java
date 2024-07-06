package com.wsd.ecommerce.repository;

import com.wsd.ecommerce.entity.ProductDetails;
import com.wsd.ecommerce.projection.ProductDetailProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer> {

    @Query(value = """
            WITH TopItems AS (
            	SELECT sd.inv_fg_stock_details_id
            	FROM sales_details sd
            	GROUP BY sd.inv_fg_stock_details_id
            	ORDER BY COUNT(1) DESC
            	LIMIT 5
            )
            SELECT
            	ifsd.barcode_no AS barcodeNo,
            	ifsd.id AS productDetailId,
            	ifsd.price AS price,
            	ifsd.item_description AS description,
            	ifsd.color AS color,
            	ifsd.`size` AS productSize,
            	ifsd.stock_status AS stockStatus
            FROM inv_fg_stock_details ifsd
            INNER JOIN TopItems ti ON ifsd.id = ti.inv_fg_stock_details_id;
            """, nativeQuery = true)
    List<ProductDetailProjection> getTopItems();
}
