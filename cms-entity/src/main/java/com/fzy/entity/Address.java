package com.fzy.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

/**
 * @program: Address
 * @description:
 * @author: fzy
 * @date: 2018-10-27 19:40
 **/
@Data
@ApiModel(value = "Address",description = "收货地址")
public class Address implements Serializable {

    private static final long serialVersionUID = -302717170222575594L;

    /**
     * ID
     */
    @ApiModelProperty(name = "ID" ,value = "addressId")
    private String addressId;

    /**
     * 买家openid
     */
    @ApiModelProperty(name = "openid",value = "买家openid")
    private String openId;

    /**
     * 买家收货地址
     */
    @ApiModelProperty(name = "买家收货地址" ,value = "buyer_address")
    private String buyerAddress;

    /**
     * 买家名称
     */
    @ApiModelProperty(name = "买家名称" ,value = "buyerName")
    private String buyerName;

    /**
     * 买家电话
     */
    //@Pattern(regexp = "^1[34578]\\d{9}$",message = "电话号码不正确")
    @ApiModelProperty(name = "买家电话" ,value = "buyerPhone")
    private String buyerPhone;

    /**
     * 邮政编码
     */
    @ApiModelProperty(name = "邮政编码" ,value = "postalCode")
    private String postalCode;

    /**
     * 是否是默认收货地址
     */
    @ApiModelProperty(name = "isDefault", value = "(0默认收货地址)")
    private Integer isDefault;

}
