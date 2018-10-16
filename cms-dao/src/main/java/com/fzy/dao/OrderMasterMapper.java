package com.fzy.dao;

import com.fzy.entity.OrderMaster;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;


/**
 * @program: OrderMasterMapper
 * @description:
 * @author: fzy
 * @date: 2018-10-01 16:26
 **/
public interface OrderMasterMapper {

    /**
     * 添加商品
     * @param orderMaster 订单
     * @return
     */
    int save(OrderMaster orderMaster);

    /**
     * 根据订单ID查询订单
     * @param orderId 订单ID
     * @return
     */
    OrderMaster findById(@Param("orderId") String orderId);

    /**
     * 根据买家openid 查询订单列表
     * @param openid 订单ID
     * @return
     */
    Page<OrderMaster> findByOpenid(@Param("openid") String openid);

    /**
     * 更新订单状态
     * @param orderId 订单ID
     * @param orderStatus 订单状态
     * @return
     */
    int updateOrderStatus(@Param("orderId") String orderId, @Param("orderStatus") Integer orderStatus);

    /**
     * 更新支付状态
     * @param orderId 订单ID
     * @param payStatus 订单状态
     * @return
     */
    int updatePayStatus(@Param("orderId") String orderId, @Param("payStatus") Integer payStatus);

    /**
     * 根据openid 和 orderId 查询一个订单
     * @param openid
     * @param orderId
     * @return
     */
    OrderMaster findByIdAndOpenid(@Param("openId") String openid, @Param("orderId") String orderId);
}
