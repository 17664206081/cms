package com.fzy.service.discount;

import com.fzy.entity.enums.DiscountTypeEnum;
import com.fzy.service.CalPrice;
import com.fzy.service.aop.DiscountType;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: DiscountFactory
 * @description:
 * @author: fzy
 * @date: 2019-02-09 00:03
 **/
public class DiscountFactory {

    //订单类型列表
    private List<Class<? extends CalPrice>> calPriceList;

    //这里是一个常量，表示我们扫描策略的包
    private static final String CAL_PRICE_PACKAGE = "com.fzy.service.discount";

    //我们加载策略时的类加载器，我们任何类运行时信息必须来自该类加载器
    private ClassLoader classLoader = getClass().getClassLoader();

    public CalPrice createCalPrice(DiscountTypeEnum typeEnum){
        for (Class<? extends CalPrice> clazz : calPriceList) {
            DiscountType discountType = handleAnnotation(clazz);
            if(typeEnum.equals(discountType.value())){
                try {
                    return clazz.newInstance();
                }catch (Exception e){
                    throw new RuntimeException("获取策略失败");
                }
            }
        }
        throw new RuntimeException("获取策略失败");
    }

    //处理注解，我们传入一个策略类，返回它的注解
    private DiscountType handleAnnotation(Class<? extends CalPrice> clazz){
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        if (annotations == null || annotations.length == 0) {
            return null;
        }
        for (int i = 0; i < annotations.length; i++) {
            if (annotations[i] instanceof DiscountType) {
                return (DiscountType) annotations[i];
            }
        }
        return null;
    }

    private DiscountFactory(){
        calPriceList=new ArrayList<>();
        File[] resources = getResources();//获取到包下所有的class文件
        Class<CalPrice> calPriceClazz = null;
        try {
            calPriceClazz = (Class<CalPrice>) classLoader.loadClass(CalPrice.class.getName());//使用相同的加载器加载策略接口
        } catch (ClassNotFoundException e1) {
            throw new RuntimeException("未找到策略接口");
        }
        for (int i = 0; i < resources.length; i++) {
            try {
                //载入包下的类
                Class<?> clazz = classLoader.loadClass(CAL_PRICE_PACKAGE + "."+resources[i].getName().replace(".class", ""));
                //判断是否是CalPrice的实现类并且不是CalPrice它本身，满足的话加入到策略列表
                if (CalPrice.class.isAssignableFrom(clazz) && clazz != calPriceClazz) {
                    calPriceList.add((Class<? extends CalPrice>) clazz);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    public static DiscountFactory getInstance(){
        return DiscountFactoryInstance.instance;
    }

    private static class DiscountFactoryInstance{
        private static DiscountFactory instance = new DiscountFactory();
    }

    private File[] getResources(){
        try {
            File file = new File(classLoader.getResource(CAL_PRICE_PACKAGE.replace(".", "/")).toURI());
            return file.listFiles(new FileFilter() {
                public boolean accept(File pathname) {
                    if (pathname.getName().endsWith(".class")) {//我们只扫描class文件
                        return true;
                    }
                    return false;
                }
            });
        } catch (URISyntaxException e) {
            throw new RuntimeException("未找到策略资源");
        }
    }

}
