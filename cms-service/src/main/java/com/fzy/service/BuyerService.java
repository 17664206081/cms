package com.fzy.service;


import com.fzy.entity.dto.OrderDto;

/**
 * @program: BuyerService
 * @description:
 * @author: fzy
 * @date: 2018-10-07 10:29
 **/
public interface BuyerService {
    //查询一个订单
    OrderDto findOrderOne(String openid, String orderId) throws Exception;

    //取消订单
    OrderDto cancelOrder(String openid, String orderId) throws Exception;
}
