package com.fzy.service;

import com.fzy.entity.ProductCategory;

import java.util.List;

/**
 * @program: CategoryService
 * @description:
 * @author: fzy
 * @date: 2018-10-16 13:25
 **/
public interface CategoryService {

    /**
     * 查询全部商品类型
     * @return
     * @throws Exception
     */
    List<ProductCategory> findAll() throws Exception;

    /**
     * 添加商品类型
     * @param productCategory
     * @return
     * @throws Exception
     */
    int save(ProductCategory productCategory) throws Exception;

    /**
     * 更新商品类型
     * @param productCategory
     * @return
     * @throws Exception
     */
    int update(ProductCategory productCategory) throws Exception;
}
