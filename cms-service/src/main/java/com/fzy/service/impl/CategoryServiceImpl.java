package com.fzy.service.impl;

import com.fzy.dao.ProductCategoryMapper;
import com.fzy.entity.ProductCategory;
import com.fzy.entity.enums.ResultEnum;
import com.fzy.exception.ServiceException;
import com.fzy.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @program: CategoryServiceImpl
 * @description:
 * @author: fzy
 * @date: 2018-10-16 13:28
 **/
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategory> findAll() throws Exception {
        return  productCategoryMapper.findAll();
    }

    @Override
    public int save(ProductCategory productCategory) throws Exception {
        if(!StringUtils.isEmpty(productCategory.getCategoryType())){
            ProductCategory category = productCategoryMapper.findById(productCategory.getCategoryType());
            if (null== category){
                log.error("商品类别不存在 ProductCategory= {}",productCategory);
                throw new ServiceException(ResultEnum.PRODUCT_CATEGORY_NOT_EXIST);
            }
        }
        return productCategoryMapper.save(productCategory);
    }

    @Override
    public int update(@RequestBody  ProductCategory productCategory) throws Exception {
        ProductCategory category = productCategoryMapper.findById(productCategory.getCategoryId());
        if(null==category){
            throw new ServiceException(ResultEnum.PRODUCT_CATEGORY_NOT_EXIST);
        }
        category.setCategoryName(productCategory.getCategoryName());
        category.setCategoryType(productCategory.getCategoryType());
        return productCategoryMapper.update(category);
    }

}
