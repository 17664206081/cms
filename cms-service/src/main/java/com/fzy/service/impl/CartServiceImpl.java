package com.fzy.service.impl;

import com.fzy.dao.CartMapper;
import com.fzy.dao.ProductInfoMapper;
import com.fzy.entity.Cart;
import com.fzy.entity.ProductInfo;
import com.fzy.entity.dto.CartDto;
import com.fzy.entity.enums.ResultEnum;
import com.fzy.exception.ServiceException;
import com.fzy.service.CartService;
import com.fzy.utils.UUIDUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public int save(Cart cart) throws Exception {
        cart.setCartId(UUIDUtil.createUUID());
        return cartMapper.save(cart);
    }

    @Override
    public int findAllCount(String openId) throws Exception {
        return cartMapper.findAllCount(openId);
    }

    @Override
    public List<CartDto> findAllList(String openId) throws Exception {
        List<Cart> cartList = cartMapper.findAllList(openId);
        List<CartDto> cartDtoList=new ArrayList<>();

        for (Cart cart : cartList) {
            CartDto cartDto=new CartDto();
            BeanUtils.copyProperties(cart,cartDto);
            ProductInfo info = productInfoMapper.findById(cart.getProductId());
            cartDto.setProductPrice(info.getProductPrice());
            cartDto.setProductName(info.getProductName());
            cartDto.setProductIcon(info.getProductIcon().split(",")[0]);
            cartDtoList.add(cartDto);
        }
        return cartDtoList;
    }

    @Override
    public int updateProductNum(String CartId,Integer productNum) throws Exception {
        //1.根据ID查询信息
        Cart cart = cartMapper.findById(CartId);
        if(null == cart){
            throw new ServiceException(ResultEnum.CART_EMPTY);
        }
        return cartMapper.updateProductNum(CartId,productNum);
    }

    @Override
    public int batchDelete(List<String> cartIds) throws Exception {
        return cartMapper.batchDelete(cartIds);
    }
}
