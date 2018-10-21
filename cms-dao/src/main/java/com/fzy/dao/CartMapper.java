package com.fzy.dao;

import com.fzy.entity.Cart;

/**
 * @program: CartMapper
 * @description:
 * @author: fzy
 * @date: 2018-10-21 19:13
 **/
public interface CartMapper {

    int save(Cart cart);

    int findAllCount(String openId);
}
