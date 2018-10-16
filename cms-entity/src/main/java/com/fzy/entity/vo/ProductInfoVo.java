package com.fzy.entity.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: ProductInfoVo
 * @description: 商品详情
 * @author: fzy
 * @create: 2018-09-15 14:51
 **/
@Data
public class ProductInfoVo {
    @JsonProperty("id")
    private String productId;
    @JsonProperty("name")
    private String productName;
    @JsonProperty("price")
    private BigDecimal productPrice;
    @JsonProperty("description")
    private  String productDescription;
    @JsonProperty("icon")
    private String productIcon;
}
