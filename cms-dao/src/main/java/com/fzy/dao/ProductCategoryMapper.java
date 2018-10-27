package com.fzy.dao;

import com.fzy.entity.ProductCategory;
import java.util.List;

public interface ProductCategoryMapper {

    /**
     * 查询全部类别
     * @return 结果列表
     * @throws Exception
     */
    List<ProductCategory> findAll();

    /**
     * 插入商品类别
     * @param productCategory
     * @return 成功返回行号 失败-1
     */
    int save(ProductCategory productCategory);

    /**
     * 查询商品类别是否存在
     * @param categoryId
     * @return
     */
    ProductCategory findOne(String categoryId);


    /**
     * 根据ID查询商品类型
     * @param CategoryId
     * @return
     */
    ProductCategory findById(Integer CategoryId);

    /**
     * 更新商品类别信息
     * @param productCategory
     * @return
     */
    int update(ProductCategory productCategory);

}
