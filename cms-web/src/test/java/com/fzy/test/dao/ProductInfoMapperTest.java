package com.fzy.test.dao;

import com.fzy.dao.ProductInfoMapper;
import com.fzy.entity.ProductInfo;
import com.fzy.entity.enums.ProductStatusEnum;
import com.fzy.utils.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.util.List;

/**
 * @program: ProductInfoMapperTest
 * @description:
 * @author: fzy
 * @date: 2018-10-15 16:05
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductInfoMapperTest {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Test
    public void save() {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId(UUIDUtil.createUUID());
        productInfo.setProductName("12期免息vivo NEX官方正品nex手机vivonex限量版oppofindx旗艦店");
        productInfo.setProductPrice(new BigDecimal(13));
        productInfo.setProductStock(101);
        productInfo.setCategoryType(2);
        productInfo.setProductIcon("https://gd4.alicdn.com/imgextra/i4/100038105/TB24D0_o5CYBuNkHFCcXXcHtVXa_!!100038105.jpg_400x400.jpg_.webp,https://gd4.alicdn.com/imgextra/i4/100038105/TB2KH.8xoR1BeNjy0FmXXb0wVXa_!!100038105.jpg_400x400.jpg_.webp,https://gd4.alicdn.com/imgextra/i4/100038105/TB24D0_o5CYBuNkHFCcXXcHtVXa_!!100038105.jpg_400x400.jpg_.webp");
        productInfo.setProductDescription("手机中的战斗机");
        int result = productInfoMapper.save(productInfo);
        Assert.assertEquals(1,result);
    }

    @Test
    public void update() {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("d9aa116e6f6a476aa046f607af47187a");
        productInfo.setProductName("红苹果");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setCategoryType(2);
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductDescription("这是一个最新的产品");
        int result = productInfoMapper.update(productInfo);
        Assert.assertEquals(1,result);
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productInfoMapper.findUpAll();
        for (ProductInfo productInfo : list) {
            log.info("上架的商品信息{}",productInfo);
        }
    }

    @Test
    public void findAll() {
        List<ProductInfo> productList = productInfoMapper.findAll();
        for (ProductInfo productInfo : productList) {
            log.info("商品信息{}",productInfo);
        }
    }

    @Test
    public void updateSale() {
        productInfoMapper.updateSale("7c289698ff52417e9272d356add21f64", ProductStatusEnum.sell.getCode());
    }

    @Test
    public void delete() {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("aebdd37d59a644d0879e75a418461c66");
        int res=productInfoMapper.delete(productInfo);
        log.info("res{}",res);
    }

    @Test
    public void findById() {
        ProductInfo productInfo = productInfoMapper.findById("7c289698ff52417e9272d356add21f64");
        log.info("商品信息:{}",productInfo);
    }
}