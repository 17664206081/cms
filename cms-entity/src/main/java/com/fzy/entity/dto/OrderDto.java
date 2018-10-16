package com.fzy.entity.dto;


import com.fzy.entity.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @program: OrderDto
 * @description:
 * @author: fzy
 * @date: 2018-09-30 19:07
 **/
@Data
public class OrderDto{

    /**
     * 订单编号
     */
    private String orderId;

    /**
     * 买家名称
     */
    private String buyerName;

    /**
     * 买家电话
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAdder;

    /**
     * 买家openid微信授权
     */
    private String buyerOpenid;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 支付状态
     */
    private Integer payStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 订单详情
     */
    private List<OrderDetail> orderDetailList;
}
