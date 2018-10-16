package com.fzy.service;

import com.fzy.CmsApplication;
import com.fzy.entity.ProductInfo;
import com.fzy.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @program: ProductServiceTest
 * @description:
 * @author: fzy
 * @date: 2018-10-15 20:55
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void save() throws Exception {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId(KeyUtil.createUUID());
        productInfo.setProductName("小面包");
        productInfo.setProductPrice(new BigDecimal(1.5));
        productInfo.setProductStock(10);
        productInfo.setCategoryType(2);
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductDescription("好吃");
        productService.save(productInfo,"2");
    }

    @Test
    public void findUpAll() {
    }

    @Test
    public void onSale() {
    }

    @Test
    public void offSale() {
    }

    @Test
    public void increaseStock() {
    }

    @Test
    public void decreaseStock() {
    }

    @Test
    public void findById() {
    }
}