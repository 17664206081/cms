package com.fzy.test.redis;

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
 * @date: 2018-11-10 13:49
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void add(){
        redisUtil.set("bbb","tt");
    }
}
