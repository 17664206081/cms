package com.fzy.service;

import com.fzy.entity.OrderMaster;
import com.fzy.entity.dto.OrderDto;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;

/**
 * @program: OrderService
 * @description:订单业务接口
 * @author: fzy
 * @create: 2018-09-15 20:25
 **/
@Service
public interface OrderService {
    /**
     * 创建订单
     */
    OrderDto create(OrderDto orderDto) throws Exception;

    /**
     * 查询单个订单
     */
    OrderDto findOne(String orderId)throws Exception;

    /**
     * 查询订单列表
     */
    Page<OrderMaster> findList(String buyerOpenid)throws Exception;

    /**
     * 取消订单
     */
    OrderDto cancel(OrderDto orderDto)throws Exception;

    /**
     * 完结订单
     */
    OrderDto finish(OrderDto orderDto)throws Exception;

    /**
     * 支付订单
     */
    OrderDto pay(OrderDto orderDto)throws Exception;
}


