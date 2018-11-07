package com.fzy.entity.enums;

import lombok.Getter;

/**
 * @program: CouponEnum
 * @description:
 * @author: fzy
 * @date: 2018-10-29 20:18
 **/
@Getter
public enum CouponEnum {

    NO_RECEIVE(0,"未领取"),
    USER(1,"已使用"),
    NO_USER(2,"未使用");

    /**
     * 状态码
     */
    private Integer code;

    /**
     *状态值
     */
    private String msg;

    CouponEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
