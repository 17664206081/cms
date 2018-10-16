package com.fzy.utils;

import java.util.UUID;

/**
 * @program: KeyUtil
 * @description: UUID工具类
 * @author: fzy
 * @create: 2018-09-15 19:10
 **/
public class KeyUtil {

    public static synchronized String createUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
