package com.fzy.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sun.reflect.generics.tree.ClassSignature;
import sun.reflect.generics.tree.ClassTypeSignature;

import java.lang.reflect.Method;


/**
 * @program: OrderTypeAop
 * @description:
 * @author: fzy
 * @date: 2019-02-08 19:31
 **/
@Component
@Aspect
//@Order(1) 执行的顺序
public class OrderTypeAop {

    /**
     * 定义切点表达式
     */
    //@Pointcut("@annotation(com.fzy.service.aop.OrderType)")
    @Pointcut("@within(com.fzy.service.aop.OrderType)")
    public void annotationPointCut(){}

    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint){
        Object target = joinPoint.getTarget();
        OrderType type = target.getClass().getAnnotation(OrderType.class);
        System.out.println("当前订单类型: "+type.value());
    }


}
