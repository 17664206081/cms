package com.fzy.controller;

import com.fzy.entity.OrderMaster;
import com.fzy.entity.dto.OrderDto;
import com.fzy.entity.enums.ResultEnum;
import com.fzy.entity.parameter.OrderParameter;
import com.fzy.entity.vo.ResultVo;
import com.fzy.exception.WebException;
import com.fzy.service.BuyerService;
import com.fzy.service.OrderService;
import com.fzy.utils.ResultVOUtil;
import com.fzy.utils.convert.OrderParameter2OrderDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: BuyerProductController
 * @description: 买家端
 * @author: fzy
 * @create: 2018-09-15 14:29
 **/
@RestController
@RequestMapping("/buyer/order")
@Api(tags="订单")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    @PostMapping("/create")
    @ApiOperation("创建订单")
    public ResultVo create(@Valid @RequestBody OrderParameter orderParameter, BindingResult bindingResult){
        try {
            if(bindingResult.hasErrors()){
                log.error("创建订单错误,OrderParameter{}",orderParameter);
                throw new WebException(ResultEnum.PARAM_ERROR.getCode(),
                        bindingResult.getFieldError().getDefaultMessage());
            }

            //对象转换
            OrderDto orderDto = OrderParameter2OrderDTO.convert(orderParameter);
            if (CollectionUtils.isEmpty(orderDto.getOrderDetailList())) {
                log.error("【创建订单】购物车不能为空");
                throw new WebException(ResultEnum.CART_EMPTY);
            }

            //创建订单
            OrderDto createResult=orderService.create(orderDto);
            Map<String, String> map = new HashMap<>();
            map.put("orderId", createResult.getOrderId());
            return ResultVOUtil.success(map);
        }catch (Exception e){
            log.error("创建订单失败, {}",e.getMessage());
            return ResultVOUtil.error(1001,"创建订单失败");
        }
    }

    //订单列表
    @GetMapping("/list")
    @ApiOperation("订单列表")
    public ResultVo list(@RequestParam("openId") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size){
        try {
            if (StringUtils.isEmpty(openid)) {
                log.error("【查询订单列表】openid为空");
                throw new WebException(ResultEnum.PARAM_ERROR);
            }
            HashMap<String,Object> map=new HashMap<>();

            PageHelper.startPage(page, size,"create_time desc");
            Page<OrderMaster> orderDTOPage = orderService.findList(openid);
            map.put("pages",orderDTOPage.getPages());
            map.put("pageSize",orderDTOPage.getPageSize());
            map.put("pageNum",orderDTOPage.getPageNum());
            map.put("list",orderDTOPage);
            return ResultVOUtil.success(map);
        } catch (Exception e) {
            log.error("查询订单失败 {}",e.getMessage());
            return ResultVOUtil.error(1002,"查询订单失败");
        }
    }

    //订单详情
    @GetMapping("/detail")
    @ApiOperation("订单详情")
    public ResultVo detail(@RequestParam("openId") String openid,
                                     @RequestParam("orderId") String orderId) {
        try {
            OrderDto orderDTO = buyerService.findOrderOne(openid, orderId);
            return ResultVOUtil.success(orderDTO);
        } catch (Exception e) {
            log.error("查询订单详情失败 {}",e.getMessage());
            return ResultVOUtil.error(1004,"查询订单详情失败");
        }
    }

    //取消订单
    @PostMapping("/cancel")
    @ApiOperation("取消订单")
    public ResultVo cancel(@RequestParam("openId") String openid,
                           @RequestParam("orderId") String orderId) {
        try {
            buyerService.cancelOrder(openid, orderId);
            return ResultVOUtil.success();
        } catch (Exception e) {
            log.error("取消订单失败 {}",e.getMessage());
            return ResultVOUtil.error(1003,"取消订单失败");
        }

    }
}
