package com.wsd.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "customer_info")
public class CustomerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 250)
    private String name;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "mobile_no", length = 55)
    private String mobileNo;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "remarks", columnDefinition = "TEXT")
    private String remarks;
}
