package com.fzy.dao;

import com.fzy.entity.ProductCategory;
import java.util.List;

public interface ProductCategoryMapper {

    /**
     * 查询全部数据
     * @return 结果列表
     * @throws Exception
     */
    List<ProductCategory> findAll();

    /**
     * 插入商品
     * @param productCategory
     * @return 成功返回行号 失败-1
     */
    int save(ProductCategory productCategory);

    /**
     * 查询商品是否存在
     * @param categoryType
     * @return
     */
    ProductCategory findOne(String categoryType);

}
