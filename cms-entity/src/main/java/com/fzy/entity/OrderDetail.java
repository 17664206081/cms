package com.fzy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class OrderDetail implements Serializable {

    public OrderDetail(String productId,Integer productQuantity){
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
