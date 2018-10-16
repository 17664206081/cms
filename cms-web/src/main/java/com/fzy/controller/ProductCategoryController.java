package com.fzy.controller;

import com.fzy.entity.ProductCategory;
import com.fzy.entity.dto.OrderDto;
import com.fzy.entity.enums.ResultEnum;
import com.fzy.entity.parameter.OrderParameter;
import com.fzy.entity.vo.ResultVo;
import com.fzy.exception.WebException;
import com.fzy.service.CategoryService;
import com.fzy.utils.ResultVOUtil;
import com.fzy.utils.convert.OrderParameter2OrderDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: ProductCategoryController
 * @description:
 * @author: fzy
 * @date: 2018-10-16 13:20
 **/
@RestController
@RequestMapping("/seller/productCategory")
@Api(tags="商品类别")
@Slf4j
public class ProductCategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    @ApiOperation("创建商品类别")
    public ResultVo create(@RequestBody ProductCategory productCategory){
        try {
            int category = categoryService.save(productCategory);
            if(category> 0){
                return ResultVOUtil.success("创建商品类别成功");
            }
            return ResultVOUtil.error(1001, "创建商品类别失败");
        } catch (Exception e) {
            log.error("创建订单失败, {}", e.getMessage());
            return ResultVOUtil.error(1001, "创建商品类别失败");
        }
    }

    @PostMapping("/update")
    @ApiOperation("修改商品类别信息")
    public ResultVo update(@RequestBody ProductCategory productCategory){
        try {
            int category = categoryService.update(productCategory);
            if(category> 0){
                return ResultVOUtil.success("修改商品类别成功");
            }
            return ResultVOUtil.error(1001, "修改商品类别失败");
        } catch (Exception e) {
            log.error("修改商品类别失败, {}", e.getMessage());
            return ResultVOUtil.error(1001, "修改商品类别失败");
        }
    }

    @PostMapping("/findAll")
    @ApiOperation("查询全部商品类别信息")
    public ResultVo findAll(){
        try {
            List<ProductCategory> list = categoryService.findAll();
            return ResultVOUtil.success(list);
        } catch (Exception e) {
            log.error("创建订单失败, {}", e.getMessage());
            return ResultVOUtil.error(1001, "修改商品类别失败");
        }
    }

}
