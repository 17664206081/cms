package com.fzy.dao;

import com.fzy.entity.Cart;
import com.fzy.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: CartMapperTest
 * @description:
 * @author: fzy
 * @date: 2018-10-21 20:58
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CartMapperTest {

    @Autowired
    private CartMapper cartMapper;

    @Test
    public void save() {
        Cart cart=new Cart();
        cart.setCartId(KeyUtil.createUUID());
        cart.setOpenId("1121");
        cart.setProductId("123");
        cart.setProductNum(12);
        cartMapper.save(cart);
    }
}