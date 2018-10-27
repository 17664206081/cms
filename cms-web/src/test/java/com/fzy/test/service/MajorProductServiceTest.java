package com.fzy.test.service;

import com.fzy.entity.MajorProduct;
import com.fzy.service.MajorProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @program: MajorProductServiceTest
 * @description:
 * @author: fzy
 * @date: 2018-10-25 18:56
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MajorProductServiceTest {

    @Autowired
    private MajorProductService majorProductService;

    @Test
    public void save() throws Exception {
        majorProductService.save("1a93cb8d40954a2cb9a9466592b69ba2");
    }

    @Test
    public void findAll() throws Exception {
        List<MajorProduct> all = majorProductService.findAll();
        System.out.println(all);
    }

    @Test
    public void delete() throws Exception {
     majorProductService.delete("b2572634d1194449a62cf5537e360155");
    }

}