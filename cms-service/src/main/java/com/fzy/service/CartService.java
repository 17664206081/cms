package com.fzy.service;

import com.fzy.entity.Cart;

/**
 * @program: CartService
 * @description:
 * @author: fzy
 * @date: 2018-10-21 20:27
 **/
public interface CartService {
    /**
     * 创建购物车
     * @param cart
     * @return
     * @throws Exception
     */
    int save(Cart cart) throws Exception;


    /**
     * 查询购物车
     * @param openId
     * @return
     * @throws Exception
     */
    int findAllCount(String openId) throws Exception;


}
