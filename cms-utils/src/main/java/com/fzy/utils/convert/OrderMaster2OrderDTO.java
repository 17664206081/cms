package com.fzy.utils.convert;

import com.fzy.entity.OrderMaster;
import com.fzy.entity.dto.OrderDto;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: OrderMaster2OrderDTO
 * @description:
 * @author: fzy
 * @date: 2018-10-07 10:19
 **/
public class OrderMaster2OrderDTO {

    public static OrderDto convert(OrderMaster orderMaster) {
        OrderDto orderDTO = new OrderDto();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDto> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(e -> convert(e))
                .collect(Collectors.toList());
    }
}
