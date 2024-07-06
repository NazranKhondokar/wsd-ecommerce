package com.wsd.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_wish")
public class CustomerWish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_detail_id")
    private Integer productDetailId;

    @Column(name = "customer_id")
    private Integer customerId;
}
