package com.fzy.utils.convert;

import com.fzy.entity.OrderDetail;
import com.fzy.entity.dto.OrderDto;
import com.fzy.entity.enums.ResultEnum;
import com.fzy.entity.parameter.OrderParameter;
import com.fzy.exception.WebException;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: OrderParameter2OrderDTO
 * @description:
 * @author: fzy
 * @date: 2018-10-07 09:28
 **/
@Slf4j
public class OrderParameter2OrderDTO {
    public static OrderDto convert(OrderParameter orderParameter) {
        Gson gson = new Gson();
        OrderDto orderDTO = new OrderDto();

        orderDTO.setBuyerName(orderParameter.getName());
        orderDTO.setBuyerPhone(orderParameter.getPhone());
        orderDTO.setBuyerAdder(orderParameter.getAddress());
        orderDTO.setBuyerOpenid(orderParameter.getOpenid());

        List<OrderDetail> orderDetailList=null;
        try {
            orderDetailList= orderParameter.getItems().stream()
                    .map(e-> new OrderDetail(e.getProductId(),e.getProductQuantity()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("【对象转换】错误, string={}", orderParameter.getItems());
            throw new WebException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
