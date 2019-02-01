package com.fzy.entity.enums;

import lombok.Getter;

/**
 * @program: ProductStatusEnum
 * @description: 商品状态枚举
 * @author: fzy
 * @create: 2018-09-17 16:17
 **/
@Getter
public enum  ProductStatusEnum {

    sell(0,"已上架"),
    nsell(1,"已下架");

    /**
     * 状态码
     */
    private Integer code;

    /**
     *状态值
     */
    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
