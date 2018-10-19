package com.fzy.service.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: RabbitSend
 * @description: rabbitmq发送消息
 * @author: fzy
 * @date: 2018-10-19 18:18
 **/
@Component
public class RabbitSend {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){

        String sendMsg="hello 宇哥";
        System.out.println("SenderMsg:"+sendMsg);
        rabbitTemplate.convertAndSend("hello",sendMsg);
    }

}
