package com.fzy.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: CartDto
 * @description:
 * @author: fzy
 * @date: 2018-10-22 12:35
 **/
@Data
public class CartDto {

    private String cartId;

    private String color;

    private String size;

    private String productName;

    private Integer productNum;

    private BigDecimal productPrice;

    private String productIcon;
}
