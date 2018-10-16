package com.fzy.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: CartDto
 * @description:
 * @author: fzy
 * @date: 2018-10-01 16:46
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

    private String productId;

    private Integer productQuantity;
}
