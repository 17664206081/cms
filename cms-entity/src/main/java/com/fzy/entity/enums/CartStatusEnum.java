package com.fzy.entity.enums;

import lombok.Getter;

/**
 * @program: CartStatusEnum
 * @description:
 * @author: fzy
 * @date: 2018-10-21 19:07
 **/
@Getter
public enum  CartStatusEnum {

    UNSETTLED(0,"未结算"),
    Settled(1,"已结算");

    /**
     * 状态码
     */
    private Integer code;

    /**
     *状态值
     */
    private String msg;

    CartStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
