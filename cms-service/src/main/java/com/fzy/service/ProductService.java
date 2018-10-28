package com.fzy.service;

import com.fzy.entity.ProductInfo;
import com.fzy.entity.dto.CartDto;
import com.fzy.entity.vo.ProductDetailVo;
import com.fzy.entity.vo.ProductInfoVo;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @program: ProductService
 * @description: 商品接口
 * @author: fzy
 * @create: 2018-09-15 20:20
 **/
public interface ProductService {

    /**
     * 添加商品
     * @param productInfo 商品对象
     */
    int save(ProductInfo productInfo)throws Exception;

    /**
     * 查询全部上架商品
     * @return
     */
    List<ProductInfoVo> findUpAll()throws Exception;

    /**
     * 商品上架
     * @param ProductId 商品ID
     * @return 商品对象
     */
    ProductInfo onSale(String ProductId)throws Exception;

    /**
     * 商品下架
     * @param ProductId 商品ID
     * @return 商品对象
     */
    ProductInfo offSale(String ProductId)throws Exception;

    /**
     * 添加库存
     * @param cartDto 购物车列表
     */
    void increaseStock(List<CartDto> cartDto)throws Exception;

    /**
     * 减库存
     * @param cartDto 购物车列表
     */
    void decreaseStock(List<CartDto> cartDto)throws Exception;

    /**
     * 根据ID查询商品
     * @param productId 商品ID
     * @return
     */
    ProductDetailVo findById(String productId)throws Exception;

    /**
     * 修改商品信息
     * @param productInfo 商品信息
     * @return
     * @throws Exception
     */
    int update(ProductInfo productInfo) throws Exception;


    /**
     * 删除商品信息
     * @param productId 商品ID
     * @return
     * @throws Exception
     */
    int delete(String productId) throws Exception;


    /**
     * 根据商品类别查询查询商品
     * @param category
     * @return
     * @throws Exception
     */
    List<ProductInfoVo> findByCategory(String category)throws Exception;

}
