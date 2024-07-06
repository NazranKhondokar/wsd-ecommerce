package com.wsd.ecommerce.repository;

import com.wsd.ecommerce.entity.ProductDetails;
import com.wsd.ecommerce.projection.MaxSaleDayProjection;
import com.wsd.ecommerce.projection.ProductDetailProjection;
import com.wsd.ecommerce.projection.SaleDayProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer> {

    @Query(value = """
            WITH TopItems AS (
            	SELECT 
            	    COUNT(1) AS saleCount,
            	    sd.inv_fg_stock_details_id
            	FROM sales_details sd
            	GROUP BY sd.inv_fg_stock_details_id
            	ORDER BY COUNT(1) DESC
            	LIMIT 5
            )
            SELECT
                ti.saleCount AS saleCount,
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

    @Query(value = """
            WITH TopItems AS (
            	SELECT
            	    COUNT(1) AS saleCount,
            		sd.inv_fg_stock_details_id
            	FROM sales_details AS sd
            	INNER JOIN sales s ON sd.sale_id = s.id
                WHERE s.invoice_date >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH)
            	GROUP BY sd.inv_fg_stock_details_id
            	ORDER BY COUNT(1) DESC
            	LIMIT 5
            )
            SELECT
            	ti.saleCount AS saleCount,
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
    List<ProductDetailProjection> getLastMonthTopItems();

    @Query(value = """
            SELECT
                COUNT(1) AS saleCount,
                s.invoice_date AS maxSaleDay
            FROM sales s
            WHERE
                ((IFNULL(:start, '') = '' OR IFNULL(:end, '') = '')
                OR (s.invoice_date BETWEEN :start AND :end))
            GROUP BY s.invoice_date
            ORDER BY COUNT(1) DESC
            LIMIT 1;
            """, nativeQuery = true)
    MaxSaleDayProjection getMaxSaleDay(String start, String end);

    @Query(value = """
            SELECT
                COUNT(1) AS saleCount,
                s.invoice_date AS saleDay
            FROM sales s
            WHERE
                s.invoice_date = CURDATE()
            GROUP BY s.invoice_date
            """, nativeQuery = true)
    SaleDayProjection getSaleDay();
}
