package com.fzy.service.discount;

import com.fzy.entity.enums.DiscountTypeEnum;
import com.fzy.service.CalPrice;
import com.fzy.service.aop.DiscountType;

import java.math.BigDecimal;

/**
 * @program: Common
 * @description:
 * @author: fzy
 * @date: 2019-02-09 00:09
 **/
@DiscountType(DiscountTypeEnum.COMMON)
public class Common implements CalPrice {


    @Override
    public BigDecimal calPrice(BigDecimal price) {
        return price;
    }
}
