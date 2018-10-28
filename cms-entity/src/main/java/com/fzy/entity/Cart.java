package com.fzy.entity;

import com.fzy.entity.enums.CartStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: Cart
 * @description: 购物车
 * @author: fzy
 * @date: 2018-10-21 16:44
 **/
@Data
@ApiModel(value = "Cart",description = "购物车")
public class Cart implements Serializable {

    private static final long serialVersionUID = -8517164202124461314L;

    /**
     * 购物车列表ID
     */
    @ApiModelProperty(value="购物车列表ID",name="cartId")
    private String cartId;

    /**
     * 买家的openid
     */
    @ApiModelProperty(value="买家的openid",name="openId")
    private String openId;

    /**
     * 商品ID
     */
    @ApiModelProperty(value="商品ID",name="productId")
    private String productId;

    /**
     * 商品数量
     */
    @ApiModelProperty(value="商品数量",name="productNum")
    private Integer productNum;

    /**
     * 规格
     */
    @ApiModelProperty(value="规格",name="size")
    private String size;

    /**
     * 颜色
     */
    @ApiModelProperty(value="颜色",name="color")
    private String color;

    /**
     *状态(默认0 未结算)
     */
    @ApiModelProperty(value="状态(默认0 未结算)",name="status")
    private Integer cartStatus= CartStatusEnum.UNSETTLED.getCode();
}
