package com.fzy.service.impl;

import com.fzy.dao.CartMapper;
import com.fzy.entity.Cart;
import com.fzy.service.CartService;
import com.fzy.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: CartServiceImpl
 * @description:
 * @author: fzy
 * @date: 2018-10-21 20:28
 **/
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public int save(Cart cart) throws Exception {
        cart.setCartId(KeyUtil.createUUID());
        return cartMapper.save(cart);
    }

    @Override
    public int findAllCount(String openId) throws Exception {
        return cartMapper.findAllCount(openId);
    }
}
