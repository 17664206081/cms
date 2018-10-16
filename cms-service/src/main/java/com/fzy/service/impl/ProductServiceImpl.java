package com.fzy.service.impl;


import com.fzy.dao.ProductCategoryMapper;
import com.fzy.dao.ProductInfoMapper;
import com.fzy.entity.ProductCategory;
import com.fzy.entity.ProductInfo;
import com.fzy.entity.dto.CartDto;
import com.fzy.entity.enums.ResultEnum;
import com.fzy.exception.ServiceException;
import com.fzy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: ProductServiceImpl
 * @description: 商品业务
 * @author: fzy
 * @create: 2018-09-15 20:21
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductCategoryMapper productCategoryMapper;

    @Autowired
    ProductInfoMapper productInfoMapper;

    @Override
    public void save(ProductInfo productInfo, String categoryType) {
        //1.查询商品类别是否存在
        ProductCategory category = productCategoryMapper.findOne(categoryType);
        if (category!=null){
                //2.将商品存入数据库
                productInfoMapper.save(productInfo);
        }else {
            throw new ServiceException(ResultEnum.PRODUCT_CATEGORY_NOT_EXIST);
        }
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return null;
    }

    @Override
    public ProductInfo onSale(String ProductId) {
        return null;
    }

    @Override
    public ProductInfo offSale(String ProductId) {
        return null;
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDto> cartDto) {
        for (CartDto dto : cartDto) {
            ProductInfo product = this.findById(dto.getProductId());
            if(null == product){
                throw new ServiceException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer stock=dto.getProductQuantity()+product.getProductStock();
            product.setProductStock(stock);
            //更新库存
            productInfoMapper.update(product);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDto> cartDto) {
        for (CartDto dto : cartDto) {
            ProductInfo product = this.findById(dto.getProductId());
            if(null == product){
                throw new ServiceException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer stock=product.getProductStock()-dto.getProductQuantity();
            if(stock<0){
                throw new ServiceException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            product.setProductStock(stock);
            //更新库存
            productInfoMapper.update(product);
        }
    }

    @Override
    public ProductInfo findById(String productId) {
        return productInfoMapper.findById(productId);
    }
}
