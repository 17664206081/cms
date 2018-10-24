package com.fzy.service.impl;


import com.fzy.dao.OrderDetailMapper;
import com.fzy.dao.OrderMasterMapper;
import com.fzy.dao.ProductInfoMapper;
import com.fzy.entity.OrderDetail;
import com.fzy.entity.OrderMaster;
import com.fzy.entity.ProductInfo;
import com.fzy.entity.dto.OrderDto;
import com.fzy.entity.enums.OrderStatusEnum;
import com.fzy.entity.enums.PayStatusEnum;
import com.fzy.entity.enums.ResultEnum;
import com.fzy.exception.ServiceException;
import com.fzy.service.OrderService;
import com.fzy.service.ProductService;
import com.fzy.utils.UUIDUtil;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * @program: OrderServiceImpl
 * @description:
 * @author: fzy
 * @date: 2018-09-30 19:15
 **/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    @Override
    @Transactional
    public OrderDto create(OrderDto orderDto) throws Exception {

        //订单编号
        String orderId = UUIDUtil.createUUID();
        //总价
        BigDecimal orderAmount =new BigDecimal(BigInteger.ZERO);

        //1.遍历订单列表 查询商品
        for (OrderDetail orderDetail :orderDto.getOrderDetailList()){
           ProductInfo product = productInfoMapper.findById(orderDetail.getProductId());
            if(null==product){
                throw new ServiceException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2.计算总价
            orderAmount=product.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);

            //生成订单ID和订单详情ID
            orderDetail.setDetailId(UUIDUtil.createUUID());
            orderDetail.setOrderId(orderId);
            orderDetail.setProductPrice(product.getProductPrice());
            orderDetail.setProductName(product.getProductName());
            orderDetail.setProductIcon(product.getProductIcon());

            //插入数据库
            orderDetailMapper.save(orderDetail);
        }

        //3.插入数据库(orderMaster)
        OrderMaster orderMaster=new OrderMaster();
        orderDto.setOrderId(orderId);
        BeanUtils.copyProperties(orderDto,orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterMapper.save(orderMaster);

//        //4.减少库存
//        List<CartDto> cartDtoList = orderDto.getOrderDetailList().stream().map(e ->
//                new CartDto(e.getProductId(), e.getProductQuantity())
//        ).collect(Collectors.toList());
//        productService.decreaseStock(cartDtoList);

        return orderDto;
    }

    @Override
    public OrderDto findOne(String orderId) {

        OrderMaster orderMaster = orderMasterMapper.findById(orderId);
        //订单不存在
        if(null==orderMaster){
            throw new ServiceException(ResultEnum.ORDER_NOT_EXIST);
        }
        List<OrderDetail> orderDetailList = orderDetailMapper.findByOrderId(orderMaster.getOrderId());
        //订单详情不存在
        if(null==orderDetailList){
            throw new ServiceException(ResultEnum.ORDERDETAIL_NOT_EXIST);
        }

        OrderDto orderDto=new OrderDto();
        BeanUtils.copyProperties(orderMaster,orderDto);
        orderDto.setOrderDetailList(orderDetailList);
        return orderDto;
    }

    @Override
    public Page<OrderMaster> findList(String buyerOpenid) {
        return orderMasterMapper.findByOpenid(buyerOpenid);
    }

    @Override
    @Transactional
    public OrderDto cancel(OrderDto orderDto) throws Exception {
        //1.判断订单状态
        if(!OrderStatusEnum.NEW.getCode().equals(orderDto.getOrderStatus())){
            throw new ServiceException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //修改订单状态
        orderDto.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        orderMasterMapper.updateOrderStatus(orderDto.getOrderId(),OrderStatusEnum.CANCEL.getCode());

        //添加库存
        if(CollectionUtils.isEmpty(orderDto.getOrderDetailList())){
            log.error("[取消订单]--订单中的商品为空, orderDto={}",orderDto);
            throw new ServiceException(ResultEnum.ORDER_DETAIL_EMPTY);
        }
        //java8 新特性
//        List<CartDto> list = orderDto.getOrderDetailList().stream()
//                .map(e -> new CartDto(e.getProductId(), e.getProductQuantity()))
//                .collect(Collectors.toList());

        //更新库存
        productService.increaseStock(null);

        //支付成功,需要退款
        if(PayStatusEnum.SUCCESS.getCode().equals(orderDto.getPayStatus())){
            //TODO 待开发退款
        }
        return orderDto;
    }

    @Override
    @Transactional
    public OrderDto finish(OrderDto orderDto) {
        //1.判断订单状态
        if(!OrderStatusEnum.NEW.getCode().equals(orderDto.getOrderStatus())){
            throw new ServiceException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //2.修改订单状态
        orderDto.setOrderStatus(OrderStatusEnum.FINISH.getCode());
        orderMasterMapper.updateOrderStatus(orderDto.getOrderId(),OrderStatusEnum.FINISH.getCode());
        return orderDto;
    }

    @Override
    @Transactional
    public OrderDto pay(OrderDto orderDto) {
        //1.判断订单状态
        if(!OrderStatusEnum.NEW.getCode().equals(orderDto.getOrderStatus())){
            throw new ServiceException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //1.判断支付状态
        if(!PayStatusEnum.WAIT.getCode().equals(orderDto.getPayStatus())){
            throw new ServiceException(ResultEnum.ORDER_PAY_STATUS_ERROR);
        }
        //2.修改订单状态
        orderDto.setPayStatus(PayStatusEnum.SUCCESS.getCode());
        orderMasterMapper.updatePayStatus(orderDto.getOrderId(),OrderStatusEnum.FINISH.getCode());
        return orderDto;
    }
}
