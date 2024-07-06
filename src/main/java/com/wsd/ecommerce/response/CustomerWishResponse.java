package com.wsd.ecommerce.response;

import com.wsd.ecommerce.entity.CustomerWish;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CustomerWishResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer productId;
    private Integer customerId;

    public static CustomerWishResponse select(CustomerWish customerWish) {
        CustomerWishResponse response = new CustomerWishResponse();
        response.setId(customerWish.getId());
        response.setProductId(customerWish.getProductId());
        response.setCustomerId(customerWish.getCustomerId());
        return response;
    }
}
