package com.fzy.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @program: ProductDetailVo
 * @description:
 * @author: fzy
 * @date: 2018-10-21 10:41
 **/
@Data
public class ProductDetailVo extends ProductInfoVo {

    //顶部banner图片
    private List<String> bannerImg;

    //购买次数
    private Integer buyerNum;

    //好评数
    private Integer favourable;

    //描述
    private String productDescription;

    //颜色
    private List<String> color;

    //尺寸
    private List<String> size;

    //评价
    private List<String> evaluate;

}
