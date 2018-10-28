package com.fzy.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: AddressVo
 * @description:
 * @author: fzy
 * @date: 2018-10-28 11:00
 **/
@Data
public class AddressVo {

    /**
     * ID
     */
    @ApiModelProperty(name = "ID" ,value = "addressId")
    private String addressId;

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
    @ApiModelProperty(name = "买家电话" ,value = "buyerPhone")
    private String buyerPhone;

    /**
     * 邮政编码
     */
    @ApiModelProperty(name = "邮政编码" ,value = "postalCode")
    private String postalCode;

    /**
     * 是否默认收货地址
     */
    @ApiModelProperty(name = "isDefault", value = "(0为默认收货地址)")
    private Integer isDefault;
}
