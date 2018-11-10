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

    List<Coupon> findAllOnNoUse(String openId) throws Exception;

    List<Coupon> findAllOnNOReceive(String openId)throws Exception;

    int save(Coupon coupon)throws Exception;

    /**
     * 更新优惠卷状态
     * @param coupon
     * @return
     * @throws Exception
     */
    int updateStatus(Coupon coupon) throws Exception;
}
