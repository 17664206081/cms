package com.fzy.service;

import java.math.BigDecimal;

/**
 * @program: CalPrice
 * @description:
 * @author: fzy
 * @date: 2019-02-09 00:06
 **/
public interface CalPrice {

    /**
     * 根据原价返回一个最终价格
     * @param price
     * @return
     */
    BigDecimal calPrice(BigDecimal price);
}
