package com.fzy.dao;

import com.fzy.cache.redis.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: RedisTest
 * @description:
 * @author: fzy
 * @date: 2018-10-17 21:57
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;


    @Test
    public void add() throws Exception{
        redisUtil.hset("cc1","中国","22");
    }


    @Test
    public void remove() throws Exception{
        String cc1 = redisUtil.hget("cc1", "中国");
        log.info(cc1);
    }

}
