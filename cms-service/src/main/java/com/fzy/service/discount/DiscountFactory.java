package com.fzy.service.discount;

import com.fzy.entity.enums.DiscountTypeEnum;
import com.fzy.service.CalPrice;
import com.fzy.service.aop.DiscountType;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @program: DiscountFactory
 * @description:
 * @author: fzy
 * @date: 2019-02-09 00:03
 **/
@Component
public class DiscountFactory implements ApplicationContextAware {

    //策略列表
    private static Map<String, Object> beans;

    public static CalPrice createCalPrice(DiscountTypeEnum typeEnum){
        for (Object value : beans.values()) {
            Class<?> clazz = value.getClass();
            DiscountType annotation = clazz.getAnnotation(DiscountType.class);
            if(typeEnum.equals(annotation.value())){
                try {
                    return (CalPrice) clazz.newInstance();
                }catch (Exception e){
                    throw new RuntimeException("获取策略失败");
                }
            }

        }
        throw new RuntimeException("获取策略失败");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        beans = applicationContext.getBeansWithAnnotation(DiscountType.class);
    }

}
