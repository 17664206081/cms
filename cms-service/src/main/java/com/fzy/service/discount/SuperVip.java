package com.fzy.service.discount;

import com.fzy.entity.enums.DiscountTypeEnum;
import com.fzy.service.CalPrice;
import com.fzy.service.aop.DiscountType;

import java.math.BigDecimal;

/**
 * @program: SuperVip
 * @description:
 * @author: fzy
 * @date: 2019-02-09 00:10
 **/
@DiscountType(DiscountTypeEnum.SUPER_VIP)
public class SuperVip implements CalPrice {

    private String ratio="0.7";

    @Override
    public BigDecimal calPrice(BigDecimal price) {
        return price.multiply(new BigDecimal(ratio));
    }
}
