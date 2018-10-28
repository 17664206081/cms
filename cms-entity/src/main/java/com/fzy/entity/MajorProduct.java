package com.fzy.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: MajorProduct
 * @description: 热门推荐
 * @author: fzy
 * @date: 2018-10-25 15:14
 **/
@Data
@ApiModel(value = "MajorProduct",description = "热门推荐")
public class MajorProduct implements Serializable {

    private static final long serialVersionUID = -5727902276484783535L;

    /**
     * 热门推荐ID
     */
    @ApiModelProperty(value = "majorId",name = "id")
    private String majorId;

    /**
     * 热门推荐商品ID
     */
    @ApiModelProperty(value = "productId",name = "商品ID")
    private String productId;

    /**
     * 热门推荐商品图片列表
     */
    @ApiModelProperty(value = "productImg",name = "图片列表")
    private String productImg;
}
