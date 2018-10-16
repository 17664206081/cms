package com.fzy.service.impl;

import com.fzy.dao.OrderMasterMapper;
import com.fzy.entity.dto.OrderDto;
import com.fzy.entity.enums.ResultEnum;
import com.fzy.exception.ServiceException;
import com.fzy.service.BuyerService;
import com.fzy.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: BuyerServiceImpl
 * @description:
 * @author: fzy
 * @date: 2018-10-07 10:29
 **/
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDto findOrderOne(String openid, String orderId)throws Exception {
        OrderDto orderDto = orderService.findOne(orderId);
        if (orderDto==null){
            return null;
        }
        if(!orderDto.getBuyerOpenid().equals(openid)){
            log.error("【查询订单】订单的openid不一致. openid={}, orderDTO={}", openid, orderDto);
            throw new ServiceException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDto;
    }

    @Override
    public OrderDto cancelOrder(String openid, String orderId) throws Exception {
        OrderDto orderOne = this.findOrderOne(openid, orderId);
        if (orderOne==null){
            log.error("【取消订单】查不到改订单, orderId={}", orderId);
            throw new ServiceException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderOne);
    }
}
