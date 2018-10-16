package com.fzy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fzy.entity.enums.OrderStatusEnum;
import com.fzy.entity.enums.PayStatusEnum;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @program: OrderMaster
 * @description: 订单实体
 * @author: fzy
 * @create: 2018-09-15 17:20
 **/
@Data
public class OrderMaster implements Serializable {

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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /**
     * 支付状态
     */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}