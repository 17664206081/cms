package com.fzy.controller;

import com.fzy.dao.ProductInfoMapper;
import com.fzy.entity.ProductInfo;
import com.fzy.entity.vo.ProductInfoVo;
import com.fzy.entity.vo.ProductVo;
import com.fzy.entity.vo.ResultVo;
import com.fzy.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @program: BuyerProductController
 * @description: 买家
 * @author: fzy
 * @create: 2018-09-15 14:29
 **/
@RestController
@RequestMapping("/buyer/product")
@Api(tags="商品")
public class BuyerProductController {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @GetMapping("/list")
    @ApiOperation("商品列表")
    public ResultVo list(){
        List<ProductInfo> productList = productInfoMapper.findAll();
        return ResultVOUtil.success(productList);
    }
}
