package com.fzy.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: ProductCategory
 * @description: 商品类别实体
 * @author: fzy
 * @create: 2018-09-15 11:20
 **/
@Data
public class ProductCategory implements Serializable {

    /**
     * 类目ID
     */
    private Integer categoryId;
    /**
     * 类目名称
     */
    private  String categoryName;
    /**
     * 类目类型
     */
    private Integer categoryType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
