package com.fzy.entity.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @program: ProductInfoVo
 * @description: 商品详情
 * @author: fzy
 * @create: 2018-09-15 14:51
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfoVo {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private String productIcon;
}
