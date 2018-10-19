package com.fzy.service;

import com.fzy.service.rabbitmq.RabbitSend;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: RabbitMqTest
 * @description:
 * @author: fzy
 * @date: 2018-10-19 18:28
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RabbitMqTest {

    @Autowired
    private RabbitSend rabbitSend;

    @Test
    public void hello(){
        rabbitSend.send();
    }
}
