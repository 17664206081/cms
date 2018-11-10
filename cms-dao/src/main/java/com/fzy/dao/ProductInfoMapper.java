package com.fzy.dao;

import com.fzy.entity.ProductInfo;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @program: ProductInfoMapper
 * @description: 商品信息表
 * @author: fzy
 * @create: 2018-09-15 19:29
 **/
public interface ProductInfoMapper {

    /**
     * 添加商品
     * @param productInfo
     * @return
     */
    int save(ProductInfo productInfo);

    /**
     * 更新商品
     * @param productInfo
     * @return
     */
    int update(ProductInfo productInfo);

    /**
     * 查询全部上架商品
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询全部商品
     * @return
     */
    List<ProductInfo> findAll();

    /**
     * 更新商品状态
     * @param productId 商品ID
     * @param productStatus 商品状态
     * @return
     */
    int updateSale(@Param("productId") String productId, @Param("productStatus") Integer productStatus);

    /**
     * 删除商品
     * @param productInfo
     * @return
     */
    int delete(ProductInfo productInfo);

    /**
     * 根据ID查询商品
     * @param productId 商品id
     * @return
     */
    ProductInfo findById(@Param("productId") String productId);

    /**
     * 根据商品类别查询商品
     * @param category
     * @return
     */
    List<ProductInfo> findByCategory(@Param("category") Integer category);

}
