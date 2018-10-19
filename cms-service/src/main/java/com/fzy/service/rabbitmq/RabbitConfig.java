package com.fzy.service.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @program: RabbitConfig
 * @description:
 * @author: fzy
 * @date: 2018-10-19 18:05
 **/
@Component
public class RabbitConfig {

    @Bean
    public Queue queue(){
        return new Queue("hello");
    }
}
