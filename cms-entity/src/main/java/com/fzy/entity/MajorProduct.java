package com.fzy.entity;

import lombok.Data;

/**
 * @program: MajorProduct
 * @description: 热门推荐
 * @author: fzy
 * @date: 2018-10-25 15:14
 **/
@Data
public class MajorProduct {
    //id
    private String majorId;
    //列表id
    private String productId;
    //图片
    private String productImg;
}
