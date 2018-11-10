package com.fzy.controller;

import com.fzy.entity.Coupon;
import com.fzy.entity.MajorProduct;
import com.fzy.entity.vo.ResultVo;
import com.fzy.service.CouponService;
import com.fzy.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: CouponController
 * @description:
 * @author: fzy
 * @date: 2018-11-04 22:26
 **/
@RestController
@RequestMapping("/buyer/coupon")
@Api(tags="优惠卷")
@Slf4j
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping("/findAllOnNOReceive")
    @ApiOperation("查询未领取优惠卷")
    public ResultVo findAllOnNOReceive(@RequestParam String openId){
        try {
            List<Coupon> list = couponService.findAllOnNOReceive(openId);
            return ResultVOUtil.success(list);
        } catch (Exception e) {
            log.error("查询未领取优惠卷失败, {}", e.getMessage());
            return ResultVOUtil.error(1001, "查询未领取优惠卷失败");
        }
    }

    @GetMapping("/findAllOnNoUse")
    @ApiOperation("查询未使用优惠卷")
    public ResultVo findAllOnNoUse(@RequestParam String openId){
        try {
            List<Coupon> list = couponService.findAllOnNoUse(openId);
            return ResultVOUtil.success(list);
        } catch (Exception e) {
            log.error("查询未使用优惠卷失败, {}", e.getMessage());
            return ResultVOUtil.error(1001, "查询未使用优惠卷失败");
        }
    }

    @PostMapping("/save")
    @ApiOperation("添加优惠卷")
    public ResultVo save(@RequestBody Coupon coupon){
        try {
              if (couponService.save(coupon)>0){
                  return ResultVOUtil.success("添加优惠卷成功");
              }
            return ResultVOUtil.error(1001, "添加优惠卷失败");
        } catch (Exception e) {
            log.error("添加优惠卷失败, {}", e.getMessage());
            return ResultVOUtil.error(1001, "添加优惠卷失败");
        }
    }

    @PutMapping("/updateStatus")
    @ApiOperation("优惠卷领取")
    public ResultVo updateStatus(@RequestBody Coupon coupon){
        try {
            if (couponService.updateStatus(coupon)>0){
                return ResultVOUtil.success("优惠卷领取成功");
            }
            return ResultVOUtil.error(1001, "优惠卷领取失败");
        } catch (Exception e) {
            log.error("优惠卷领取失败, {}", e.getMessage());
            return ResultVOUtil.error(1001, "优惠卷领取失败");
        }
    }
}
