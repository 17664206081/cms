package com.fzy.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: ProductCategory
 * @description: 商品类别
 * @author: fzy
 * @create: 2018-09-15 11:20
 **/
@Data
@ApiModel(value = "ProductCategory",description = "商品类别")
public class ProductCategory implements Serializable {

    private static final long serialVersionUID = -1081404069350815421L;

    /**
     * 类目ID
     */
    @ApiModelProperty(value = "categoryId",name = "类目ID")
    private Integer categoryId;

    /**
     * 类目名称
     */
    @ApiModelProperty(value = "categoryName",name = "类目名称")
    private  String categoryName;

    /**
     * 类目父ID
     */
    @ApiModelProperty(value = "parentId",name = "类目父ID")
    private Integer parentId;

}
