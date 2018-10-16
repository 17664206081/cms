package com.fzy.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: ProductVo
 * @description:商品
 * @author: fzy
 * @create: 2018-09-15 14:37
 **/
@Data
public class ProductVo {

    /**
     * 类目名称
     */
    @JsonProperty("name")
    private  String categoryName;
    /**
     * 类目编号
     */
    @JsonProperty("type")
    private Integer categoryType;
    /**
     * 商品列表
     */
    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;
}
