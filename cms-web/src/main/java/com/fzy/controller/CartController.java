package com.fzy.controller;

import com.fzy.entity.Cart;
import com.fzy.entity.dto.CartDto;
import com.fzy.entity.vo.ResultVo;
import com.fzy.service.CartService;
import com.fzy.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
            log.error("查询购物车数量失败, {}", e.getMessage());
            return ResultVOUtil.error(1001, "查询购物车数量失败");
        }
    }

    @GetMapping("/findAllList")
    @ApiOperation("查询购物车列表")
    public ResultVo findAllList(@Param("openId") String openId){
        try {
            List<CartDto> allList = cartService.findAllList(openId);
            BigDecimal totalPrice=new BigDecimal(BigInteger.ZERO);

            for (CartDto cartDto : allList) {
                System.out.println(cartDto.getProductPrice());
                totalPrice=totalPrice.add(cartDto.getProductPrice());
            }

            Map<String ,Object> map=new HashMap<>();
            map.put("cartList",allList);
            map.put("totalPrice",totalPrice);
            return ResultVOUtil.success(map);
        } catch (Exception e) {
            log.error("查询购物车列表失败, {}", e.getMessage());
            return ResultVOUtil.error(1001, "查询购物车列表失败");
        }
    }

    @PostMapping("/updateProductNum")
    @ApiOperation("更新购物车数量")
    public ResultVo updateProductNum(@Param("cartId") String cartId,@Param("productNum") Integer productNum){
        try {
            int res = cartService.updateProductNum(cartId,productNum);
            if(res>0){
                return ResultVOUtil.success("更新购物车数量成功");
            }
            return ResultVOUtil.error(1001, "更新购物车数量失败");
        } catch (Exception e) {
            log.error("更新购物车数量失败, {}", e.getMessage());
            return ResultVOUtil.error(1001, "更新购物车数量失败");
        }
    }

    @PostMapping("/batchDelete")
    @ApiOperation("批量删除购物车商品")
    public ResultVo batchDelete(@RequestParam("cartIds") List<String> cartIds){
        try {
            if(cartService.batchDelete(cartIds)>0){
                return ResultVOUtil.success("批量删除购物车商品成功");
            }
            return ResultVOUtil.error(1001, "批量删除购物车商品失败");
        } catch (Exception e) {
            log.error("批量删除购物车商品失败, {}", e.getMessage());
            return ResultVOUtil.error(1001, "批量删除购物车商品失败");
        }
    }

}
