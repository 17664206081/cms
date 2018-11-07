package com.fzy.controller;

import com.fzy.entity.ProductInfo;
import com.fzy.entity.vo.ProductDetailVo;
import com.fzy.entity.vo.ProductInfoVo;
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
 * @description: 商品信息接口
 * @author: fzy
 * @create: 2018-09-15 14:29
 **/
@RestController
@RequestMapping("/buyer/product")
@Api(tags="商品信息")
@Slf4j
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/findUpAll")
    @ApiOperation("查询全部上架商品")
    public ResultVo findUpAll(){
        try {
            List<ProductInfoVo> upProduct = productService.findUpAll();
            return ResultVOUtil.success(upProduct);
        } catch (Exception e) {
            log.error("查询全部上架 err= {}",e.getMessage());
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
            log.error("创建商品失败 err= {}",e.getMessage());
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
            log.error("修改商品失败 err= {}", e.getMessage());
            return ResultVOUtil.error(1004,"修改商品失败");
        }
    }

    @GetMapping("/delete")
    @ApiOperation("删除商品")
    public ResultVo delete(@RequestParam("productId") String productId){
        try {
            if((productService.delete(productId))>0){
                return ResultVOUtil.success("删除商品成功");
            }
            return ResultVOUtil.error(1004,"删除商品失败");
        } catch (Exception e) {
            log.error("删除商品失败 err={}", e.getMessage());
            return ResultVOUtil.error(1004,"删除商品失败");
        }
    }

    @GetMapping("/findById")
    @ApiOperation("根据商品ID查询详情")
    public ResultVo findById(@RequestParam("productId") String productId){
        try {
            ProductDetailVo info = productService.findById(productId);
            if(null!=info){
                return ResultVOUtil.success(info);
            }
            return ResultVOUtil.error(1004,"根据商品ID查询详情失败");
        } catch (Exception e) {
            log.error("根据商品ID查询详情失败 err={}", e.getMessage());
            return ResultVOUtil.error(1004,"根据商品ID查询详情失败");
        }
    }

    @GetMapping("/finByCategory")
    @ApiOperation("根据类别查询商品")
    public ResultVo finByCategory(@RequestParam String category){
        try {
            List<ProductInfoVo> list = productService.findByCategory(category);
            return ResultVOUtil.success(list);
        } catch (Exception e) {
            log.error("根据类别查询商品失败, {}", e.getMessage());
            return ResultVOUtil.error(1001, "根据类别查询商品失败");
        }
    }
}
