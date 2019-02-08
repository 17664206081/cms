package com.fzy.entity.enums;

import lombok.Getter;

/**
 * @program: DiscountTypeEnum
 * @description:
 * @author: fzy
 * @date: 2019-02-09 00:18
 **/
@Getter
public enum DiscountTypeEnum {

    VIP(1,"vip"),
    GOLD_VIP(2,"goldVip"),
    SUPER_VIP(3,"superVip"),
    COMMON(4,"common");

    private Integer code;

    private String msg;

     DiscountTypeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
