package com.fzy.dao;

import com.fzy.entity.OrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @program: OrderDetailMapper
 * @description:
 * @author: fzy
 * @date: 2018-09-30 19:46
 **/
public interface OrderDetailMapper {

    /**
     * 添加商品
     * @param orderDetail
     * @return
     */
    int save(OrderDetail orderDetail);

    /**
     * 根据订单ID 查询订单详情
     * @param orderId
     * @return
     */
    List<OrderDetail> findByOrderId(@Param("orderId") String orderId);
}
