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
    public Integer id;

    @Column(name = "name", length = 250)
    public String name;

    @Column(name = "email", length = 255)
    public String email;

    @Column(name = "mobile_no", length = 55)
    public String mobileNo;

    @Column(name = "address", columnDefinition = "TEXT")
    public String address;

    @Column(name = "remarks", columnDefinition = "TEXT")
    public String remarks;
}
