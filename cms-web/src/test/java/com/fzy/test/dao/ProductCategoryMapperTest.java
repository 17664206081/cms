package com.fzy.test.dao;

import com.fzy.dao.ProductCategoryMapper;
import com.fzy.entity.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @program: ProductCategoryMapperTest
 * @description:
 * @author: fzy
 * @date: 2018-10-16 12:28
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Test
    public void findAll() {
        List<ProductCategory> list = productCategoryMapper.findAll();
        log.info("商品类型信息= {} ",list);
    }

    @Test
    public void save() {

    }

    @Test
    public void findOne() {
    }

    @Test
    public void findById() {

    }

}