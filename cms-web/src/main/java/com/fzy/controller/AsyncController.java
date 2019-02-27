package com.fzy.controller;

import com.fzy.entity.enums.DiscountTypeEnum;
import com.fzy.entity.vo.ResultVo;
import com.fzy.service.AsyncService;
import com.fzy.service.CalPrice;
import com.fzy.service.aop.DiscountType;
import com.fzy.service.discount.DiscountFactory;
import com.fzy.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.concurrent.Future;

/**
 * @program: AsyncController
 * @description:
 * @author: fzy
 * @date: 2019-02-07 14:05
 **/
@RestController
@RequestMapping("/async")
@Api(tags="异步任务")
@Slf4j
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/testAdd/{a}/{b}")
    @ApiOperation("异步任务测试1")
    public ResultVo testAdd(@PathVariable Integer a, @PathVariable Integer b ){
        try {
            Future<Integer> future = asyncService.add(a, b);
            Integer res = future.get();
            return ResultVOUtil.success(res);
        } catch (Exception e) {
            log.error("异步任务调用失败,e={}, msg={}",e, e.getMessage());
            return ResultVOUtil.error(-1, "异步任务调用失败");
        }
    }

    @GetMapping("/test2/{price}")
    @ApiOperation("异步任务测试2")
    public ResultVo test2(@PathVariable String price){
        try {
            CalPrice calPrice=DiscountFactory.createCalPrice(DiscountTypeEnum.VIP);
            BigDecimal bigDecimal = calPrice.calPrice(new BigDecimal(price));
            System.out.println(bigDecimal);
            return ResultVOUtil.success(bigDecimal);
        } catch (Exception e) {
            log.error("异步任务调用失败,e={}, msg={}",e, e.getMessage());
            return ResultVOUtil.error(-1, "异步任务调用失败");
        }
    }

}
