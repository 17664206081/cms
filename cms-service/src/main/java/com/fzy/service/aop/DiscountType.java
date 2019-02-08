package com.fzy.service.aop;

import com.fzy.entity.enums.DiscountTypeEnum;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;


/**
 * @program: DiscountType
 * @description:
 * @author: fzy
 * @date: 2019-02-07 22:50
 **/
@Retention(RetentionPolicy.RUNTIME) //注解作用目标
@Target(ElementType.TYPE) //类
@Documented //注解包含在javadoc中
@Component
public @interface DiscountType {

     /**
     * 如果注解只有一个属性，那么肯定是赋值给该属性。
     * 如果注解有多个属性，而且前提是这多个属性都有默认值，那么你不写注解名赋值，会赋值给名字为“value”这属性。
     * 如果注解有多个属性，其中有没有设置默认值的属性，那么当你不写属性名进行赋值的时候，是会报错的。
     */
    //@AliasFor("")起别名
     DiscountTypeEnum value();
}
