package com.fzy.service.impl;

import com.fzy.service.CgOrderService;
import com.fzy.service.aop.OrderType;
import org.springframework.stereotype.Service;

/**
 * @program: CgOrderServiceImpl
 * @description:
 * @author: fzy
 * @date: 2019-02-07 23:22
 **/
@Service
@OrderType("采购订单")
public class CgOrderServiceImpl implements CgOrderService {

    @Override
    public void pay() {

    }

}
