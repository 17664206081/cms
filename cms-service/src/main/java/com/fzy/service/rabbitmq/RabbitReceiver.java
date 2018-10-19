package com.fzy.service.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: RabbitReceiver
 * @description:
 * @author: fzy
 * @date: 2018-10-19 18:23
 **/
@RabbitListener(queues = "hello")
@Component
public class RabbitReceiver {

    @RabbitHandler
    public void process(String hello){
        System.out.println("receiver:"+hello);
    }
}
