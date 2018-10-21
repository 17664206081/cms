package com.fzy.controller;

import com.fzy.entity.Cart;
import com.fzy.entity.ProductCategory;
import com.fzy.entity.vo.ResultVo;
import com.fzy.service.CartService;
import com.fzy.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: CartController
 * @description:
 * @author: fzy
 * @date: 2018-10-21 20:29
 **/
@RestController
@RequestMapping("/buyer/cart")
@Api(tags="购物车")
@Slf4j
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/create")
    @ApiOperation("创建购物车")
    public ResultVo create(@RequestBody Cart cart){
        try {
            int res = cartService.save(cart);
            if(res> 0){
                return ResultVOUtil.success("加入购物成功");
            }
            return ResultVOUtil.error(1001, "加入购物车失败");
        } catch (Exception e) {
            log.error("加入购物车失败, {}", e.getMessage());
            return ResultVOUtil.error(1001, "加入购物车失败");
        }
    }

    @GetMapping("/findAllCount")
    @ApiOperation("查询购物车数量")
    public ResultVo findAllCount(@Param("openId") String openId){
        try {
            int allCount = cartService.findAllCount(openId);
            Map<String ,Object> map=new HashMap<>();
            map.put("total",allCount);
            return ResultVOUtil.success(map);
        } catch (Exception e) {
            log.error("查询购物车数量, {}", e.getMessage());
            return ResultVOUtil.error(1001, "查询购物车数量");
        }
    }
}
