package com.fzy.service;

import com.fzy.entity.Cart;
import com.fzy.entity.dto.CartDto;

import java.util.List;

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


    /**
     * 查询全部购物车列表
     * @param openId
     * @return
     * @throws Exception
     */
    List<CartDto> findAllList(String openId) throws Exception;


    /**
     * 更新购物车商品数量
     * @param CartId 商品ID
     * @return
     * @throws Exception
     */
    int updateProductNum(String CartId,Integer productNum) throws Exception;


    /**
     * 批量删除购物车商品
     * @param cartIds
     * @return
     * @throws Exception
     */
    int batchDelete(List<String>  cartIds) throws Exception;


}
