package com.fzy.entity.enums;

import lombok.Getter;

/**
 * @program: OrderStatusEnum
 * @description: 订单状态
 * @author: fzy
 * @create: 2018-09-15 17:31
 **/
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISH(1,"已完结"),
    CANCEL(2,"已取消");

    /**
     * 状态码
     */
    private Integer code;

    /**
     *状态值
     */
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
