package com.fzy.entity.enums;

import lombok.Getter;

/**
 * @program: PayStatusEnum
 * @description: 支付状态
 * @author: fzy
 * @create: 2018-09-15 17:38
 **/
@Getter
public enum PayStatusEnum {

    WAIT(0,"待支付"),
    SUCCESS(1,"支付成功");

    /**
     * 状态码
     */
    private Integer code;

    /**
     *状态值
     */
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
