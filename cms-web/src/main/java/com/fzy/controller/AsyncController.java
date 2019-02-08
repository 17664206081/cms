package com.fzy.controller;

import com.fzy.entity.vo.ResultVo;
import com.fzy.service.AsyncService;
import com.fzy.service.CgOrderService;
import com.fzy.service.aop.OrderType;
import com.fzy.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private CgOrderService cgOrderService;

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

    @GetMapping("/test2")
    @ApiOperation("异步任务测试2")
    public ResultVo test2(){
        try {
            cgOrderService.pay();
            System.out.println("111111");
            return ResultVOUtil.success(null);
        } catch (Exception e) {
            log.error("异步任务调用失败,e={}, msg={}",e, e.getMessage());
            return ResultVOUtil.error(-1, "异步任务调用失败");
        }
    }

}
