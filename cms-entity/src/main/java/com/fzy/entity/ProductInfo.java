package com.fzy.entity;


import com.fzy.entity.enums.ProductStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: ProductInfo
 * @description: 商品信息
 * @author: fzy
 * @create: 2018-09-15 17:43
 **/
@Data
@ApiModel(value = "ProductInfo",description = "商品信息")
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 793449733446526587L;
    /**
     * 商品编号
     */
    @ApiModelProperty(value = "productId",name = "商品编号")
    private String productId;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "productName",name = "商品名称")
    private String productName;

    /**
     * 商品价格
     */
    @ApiModelProperty(value = "productPrice",name = "商品价格")
    private BigDecimal productPrice;

    /**
     * 商品库存
     */
    @ApiModelProperty(value = "productStock",name = "商品库存")
    private Integer productStock;

    /**
     * 商品描述
     */
    @ApiModelProperty(value = "productDescription",name = "商品描述")
    private String productDescription;

    /**
     * 商品图标
     */
    @ApiModelProperty(value = "productIcon",name = "商品图标")
    private String productIcon;

    /**
     * 商品类别
     */
    @ApiModelProperty(value = "categoryType",name = "商品类别")
    private Integer categoryType;

    /**
     * 商品状态
     */
    @ApiModelProperty(value = "productStatus",name = "商品状态")
    private Integer productStatus= ProductStatusEnum.UP.getCode();

}
