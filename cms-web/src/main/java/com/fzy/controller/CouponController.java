package com.fzy.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/findAll")
    public void findAll(){

    }
}
