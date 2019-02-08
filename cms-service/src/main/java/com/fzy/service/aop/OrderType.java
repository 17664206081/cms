package com.fzy.service.aop;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;


/**
 * @program: OrderType
 * @description:
 * @author: fzy
 * @date: 2019-02-07 22:50
 **/
@Retention(RetentionPolicy.RUNTIME) //注解作用目标
@Target(ElementType.TYPE) //类
@Documented //注解包含在javadoc中
public @interface OrderType {

    String value() default "";
}
