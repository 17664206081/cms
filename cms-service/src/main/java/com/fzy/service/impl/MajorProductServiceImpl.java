package com.fzy.service.impl;

import com.fzy.dao.MajorProductMapper;
import com.fzy.dao.ProductInfoMapper;
import com.fzy.entity.MajorProduct;
import com.fzy.entity.ProductInfo;
import com.fzy.entity.enums.ResultEnum;
import com.fzy.exception.ServiceException;
import com.fzy.service.MajorProductService;
import com.fzy.utils.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: MajorProductServiceImpl
 * @description:
 * @author: fzy
 * @date: 2018-10-25 18:49
 **/
@Service
@Slf4j
public class MajorProductServiceImpl implements MajorProductService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Autowired
    private MajorProductMapper majorProductMapper;

    @Override
    public int save(String productId) throws Exception {

        ProductInfo productInfo = productInfoMapper.findById(productId);
        if(null==productInfo)
            throw new ServiceException(ResultEnum.PRODUCT_NOT_EXIST);

        MajorProduct majorProduct=new MajorProduct();
        majorProduct.setMajorId(UUIDUtil.createUUID());
        majorProduct.setProductId(productInfo.getProductId());
        majorProduct.setProductImg( productInfo.getProductIcon().split(",")[0]);

        return majorProductMapper.save(majorProduct);
    }

    @Override
    public int delete(String majorId) throws Exception {
        return majorProductMapper.delete(majorId);
    }

    @Override
    public List<MajorProduct> findAll() throws Exception {
        return majorProductMapper.findAll();
    }
}
