package com.fzy.entity.enums;

import lombok.Getter;

/**
 * @program: AddressEnum
 * @description:
 * @author: fzy
 * @date: 2018-10-28 19:48
 **/
@Getter
public enum AddressEnum {

    DEFAULT(0,"默认地址"),
    NO_DEFAULT(1,"非默认地址");

    /**
     * 状态码
     */
    private Integer code;

    /**
     *状态值
     */
    private String msg;

    AddressEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
