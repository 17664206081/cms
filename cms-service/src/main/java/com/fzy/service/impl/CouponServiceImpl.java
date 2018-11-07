package com.fzy.service.impl;

import com.fzy.entity.Coupon;
import com.fzy.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: CouponServiceImpl
 * @description:
 * @author: fzy
 * @date: 2018-11-04 22:24
 **/
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponService couponService;

    @Override
    public List<Coupon> findAll() {
        return couponService.findAll();
    }
}
