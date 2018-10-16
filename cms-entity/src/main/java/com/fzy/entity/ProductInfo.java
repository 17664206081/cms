package com.fzy.entity;


import com.fzy.entity.enums.ProductStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: ProductInfo
 * @description: 商品信息实体
 * @author: fzy
 * @create: 2018-09-15 17:43
 **/
@Data
public class ProductInfo implements Serializable {

    /**
     * 商品编号
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    /**
     * 商品库存
     */
    private Integer productStock;

    /**
     * 商品描述
     */
    private String productDescription;

    /**
     * 商品图标
     */
    private String productIcon;

    /**
     * 商品类别
     */
    private Integer categoryType;

    /**
     * 商品状态
     */
    private Integer productStatus= ProductStatusEnum.UP.getCode();

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
