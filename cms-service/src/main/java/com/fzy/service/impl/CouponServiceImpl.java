package com.fzy.service.impl;

import com.fzy.dao.CouponMapper;
import com.fzy.entity.Coupon;
import com.fzy.service.CouponService;
import com.fzy.utils.UUIDUtil;
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
    private CouponMapper couponMapper;

    @Override
    public List<Coupon> findAllOnNoUse(String openId) {
        return couponMapper.findAllOnNoUse(openId);
    }

    @Override
    public List<Coupon> findAllOnNOReceive(String openId) {
        return couponMapper.findAllOnNOReceive(openId);
    }

    @Override
    public int save(Coupon coupon){
        coupon.setCouponId(UUIDUtil.createUUID());
        return couponMapper.save(coupon);
    }

    @Override
    public int updateStatus(Coupon coupon){
        return couponMapper.updateStatus(coupon);
    }
}
