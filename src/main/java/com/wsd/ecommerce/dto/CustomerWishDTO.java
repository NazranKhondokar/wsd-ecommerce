package com.wsd.ecommerce.dto;

import com.wsd.ecommerce.entity.CustomerWish;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class CustomerWishDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer productDetailId;
    private Integer customerId;

    public CustomerWish to() {
        CustomerWish customerWish = new CustomerWish();
        customerWish.setProductDetailId(productDetailId);
        customerWish.setCustomerId(customerId);
        return customerWish;
    }

    public void update(CustomerWish customerWish) {
        customerWish.setCustomerId(customerId);
        customerWish.setProductDetailId(productDetailId);
    }
}
