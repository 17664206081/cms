package com.fzy.service;

import com.fzy.entity.OrderDetail;
import com.fzy.entity.dto.OrderDto;
import com.fzy.CmsApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: OrderServiceTest
 * @description:
 * @author: fzy
 * @date: 2018-10-15 20:55
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CmsApplication.class)
@Slf4j
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    private final String OPEN_ID="123123";

    @Test
    public void create() throws Exception {
        OrderDto orderDto=new OrderDto();
        orderDto.setBuyerAdder("交通学院");
        orderDto.setBuyerPhone("17862838459");
        orderDto.setBuyerName("张三");
        orderDto.setBuyerOpenid(OPEN_ID);
        List<OrderDetail> list=new ArrayList<>();
        OrderDetail o1=new OrderDetail();
        o1.setProductId("7c289698ff52417e9272d356add21f64");
        o1.setProductQuantity(2);
        OrderDetail o2=new OrderDetail();
        o2.setProductId("d7409a95294f45f7ac12f244a888f4b9");
        o2.setProductQuantity(10);
        list.add(o1);
        list.add(o2);
        orderDto.setOrderDetailList(list);
        OrderDto result = orderService.create(orderDto);
        log.info("创建订单:{}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void pay() {
    }
}