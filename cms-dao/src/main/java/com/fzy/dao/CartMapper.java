package com.fzy.dao;

import com.fzy.entity.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: CartMapper
 * @description:
 * @author: fzy
 * @date: 2018-10-21 19:13
 **/
public interface CartMapper {

    int save(Cart cart);

    int findAllCount(String openId);

    List<Cart> findAllList(String openId);

    Cart findById(String cartId);

    int updateProductNum(@Param("cartId") String cartId,@Param("productNum") Integer productNum);

    int batchDelete(@Param("cartIds")List<String> cartIds);

}
