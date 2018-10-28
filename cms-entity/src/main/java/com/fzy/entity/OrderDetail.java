package com.fzy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: OrderDetail
 * @description: 订单详情表
 * @author: fzy
 * @create: 2018-09-15 17:43
 **/
@Data
@NoArgsConstructor
@ApiModel(value = "OrderDetail",description = "订单详情表")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = -656686983117346180L;

    public OrderDetail(String productId, Integer productQuantity){
        this.productId=productId;
        this.productQuantity=productQuantity;
    }

    /**
     * 订单详情表ID
     */
    private String detailId;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    /**
     * 商品图标
     */
    private String productIcon;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
