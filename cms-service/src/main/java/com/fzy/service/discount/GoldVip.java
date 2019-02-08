package com.fzy.service.discount;

import com.fzy.entity.enums.DiscountTypeEnum;
import com.fzy.service.CalPrice;
import com.fzy.service.aop.DiscountType;

import java.math.BigDecimal;

/**
 * @program: GoldVip
 * @description:
 * @author: fzy
 * @date: 2019-02-09 00:10
 **/
@DiscountType(DiscountTypeEnum.GOLD_VIP)
public class GoldVip implements CalPrice {

    private String ratio="0.5";

    @Override
    public BigDecimal calPrice(BigDecimal price) {
        return price.multiply(new BigDecimal(ratio));
    }
}
