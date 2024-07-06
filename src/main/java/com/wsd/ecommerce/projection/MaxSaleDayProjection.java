package com.wsd.ecommerce.projection;

import java.util.Date;

public interface MaxSaleDayProjection {
    Date getMaxSaleDay();
    Integer getSaleCount();
}
