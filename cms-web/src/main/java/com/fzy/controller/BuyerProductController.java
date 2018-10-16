package com.fzy.controller;

import com.fzy.entity.ProductInfo;
import com.fzy.entity.vo.ResultVo;
import com.fzy.service.ProductService;
import com.fzy.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Slf4j
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/findUpAll")
    @ApiOperation("查询全部上架商品")
    public ResultVo findUpAll(){
        try {
            List<ProductInfo> upProduct = productService.findUpAll();
            return ResultVOUtil.success(upProduct);
        } catch (Exception e) {
            log.error("查询全部上架");
            return ResultVOUtil.error(1004,"查询全部上架失败");
        }
    }

    @PostMapping("/create")
    @ApiOperation("创建商品信息")
    public ResultVo create(@RequestBody ProductInfo ProductInfo){

        try {
            if((productService.save(ProductInfo))>0){
                return ResultVOUtil.success("创建商品成功");
            }
            return ResultVOUtil.error(1004,"创建商品失败");
        } catch (Exception e) {
            log.error("创建商品失败");
            return ResultVOUtil.error(1004,"创建商品失败");
        }
    }

    @PostMapping("/update")
    @ApiOperation("修改商品信息")
    public ResultVo update(@RequestBody ProductInfo ProductInfo){
        try {
            if((productService.update(ProductInfo))>0){
                return ResultVOUtil.success("修改商品成功");
            }
            return ResultVOUtil.error(1004,"修改商品失败");
        } catch (Exception e) {
            log.error("创建商品失败");
            return ResultVOUtil.error(1004,"修改商品失败");
        }
    }
}
