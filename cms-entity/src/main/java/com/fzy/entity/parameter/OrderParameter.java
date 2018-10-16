package com.fzy.entity.parameter;

import com.fzy.entity.dto.CartDto;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;


/**
 * @program: OrderParameter
 * @description:
 * @author: fzy
 * @date: 2018-10-07 08:51
 **/
@Data
public class OrderParameter {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "买家姓名必填")
    private String name;

    /**
     * 买家手机号
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 买家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家微信openid
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private List<CartDto> items;
}
