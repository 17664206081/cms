package com.fzy.dao;

import com.fzy.entity.Coupon;

import java.util.List;

/**
 * @program: CouponMapper
 * @description:
 * @author: fzy
 * @date: 2018-10-29 20:07
 **/
public interface CouponMapper {

    int save(Coupon coupon);

    List<Coupon> findAllOnNoUse(String openId);

    List<Coupon> findAllOnNOReceive(String openId);

    int updateStatus(Coupon coupon);

}
