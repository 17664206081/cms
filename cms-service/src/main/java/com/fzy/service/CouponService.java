package com.fzy.service;

import com.fzy.entity.Coupon;

import java.util.List;

/**
 * @program: CouponService
 * @description:
 * @author: fzy
 * @date: 2018-11-04 22:22
 **/
public interface CouponService {

    List<Coupon> findAll();
}
