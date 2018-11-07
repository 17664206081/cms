package com.fzy.test.dao;

import com.fzy.dao.CouponMapper;
import com.fzy.entity.Coupon;
import com.fzy.utils.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @program: CouponMapperTest
 * @description:
 * @author: fzy
 * @date: 2018-11-04 21:32
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CouponMapperTest {

    @Autowired
    private CouponMapper couponMapper;

    @Test
    public void save() {
        Coupon coupon=new Coupon();
        coupon.setCouponId(UUIDUtil.createUUID());
        coupon.setOpenId("123");
        coupon.setCouponPrice(new BigDecimal(20));
        coupon.setLimitPrice(new BigDecimal(500));
        coupon.setNow("2018-8-7");
        coupon.setEnd("2018-10-7");
        coupon.setRemark("今天我开心");
        couponMapper.save(coupon);
    }
}