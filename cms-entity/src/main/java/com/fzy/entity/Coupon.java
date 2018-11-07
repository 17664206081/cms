package com.fzy.entity;

import com.fzy.entity.enums.CouponEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: com.fzy.entity.Coupon
 * @description: 优惠卷
 * @author: fzy
 * @date: 2018-10-29 19:37
 **/
@Data
public class Coupon {

    @ApiModelProperty(value = "couponId",name = "ID")
    private String couponId;

    @ApiModelProperty(value = "openId",name = "买家openId")
    private String openId;

    @ApiModelProperty(value = "couponPrice",name = "优惠金额")
    private BigDecimal couponPrice;

    @ApiModelProperty(value = "remark",name = "备注")
    private String remark;

    @ApiModelProperty(value = "limitPrice",name = "满减金额")
    private BigDecimal limitPrice;

    @ApiModelProperty(value = "now",name = "有效期开始")
    private String now;

    @ApiModelProperty(value = "end",name = "有效期结束")
    private String end;

    @ApiModelProperty(value = "status",name = "优惠卷状态")
    private Integer status= CouponEnum.NO_RECEIVE.getCode();

}
