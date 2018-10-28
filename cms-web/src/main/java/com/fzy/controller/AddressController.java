package com.fzy.controller;

import com.fzy.entity.Address;
import com.fzy.entity.enums.ResultEnum;
import com.fzy.entity.vo.AddressVo;
import com.fzy.entity.vo.ResultVo;
import com.fzy.exception.WebException;
import com.fzy.service.AddressService;
import com.fzy.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/**
 * @program: AddressController
 * @description:
 * @author: fzy
 * @date: 2018-10-27 21:24
 **/
@RestController
@RequestMapping("/buyer/address")
@Api(tags="收货地址")
@Slf4j
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/save")
    @ApiOperation("添加收货地址")
    public ResultVo save(@RequestBody Address address){
        try {
           if(addressService.save(address)>0){
               return ResultVOUtil.success("添加收货地址成功");
           }
            return ResultVOUtil.error(1001, "添加收货地址失败");
        } catch (Exception e) {
            log.error("添加收货地址失败, {}", e.getMessage());
            return ResultVOUtil.error(1001, "添加收货地址失败");
        }
    }

    @GetMapping("/findAllByOpenId")
    @ApiOperation("查询全部收货地址")
    public ResultVo findAllByOpenId(@RequestParam String openId){
        try {
            List<AddressVo> list = addressService.findAllByOpenId(openId);
            return ResultVOUtil.success(list);
        } catch (Exception e) {
            log.error("查询全部收货地址失败, {}", e.getMessage());
            return ResultVOUtil.error(1001, "查询全部收货地址失败");
        }
    }

    @GetMapping("/findById")
    @ApiOperation("根据ID查询收货地址")
    public ResultVo findById(@RequestParam String addressId){
        try {
            AddressVo addressVo= addressService.findById(addressId);
            return ResultVOUtil.success(addressVo);
        } catch (Exception e) {
            log.error("根据ID查询收货地址失败, {}", e.getMessage());
            return ResultVOUtil.error(1001, "根据ID查询收货地址失败");
        }
    }

    @GetMapping("/deleteById")
    @ApiOperation("根据ID删除收货地址")
    public ResultVo deleteById(@RequestParam String addressId){
        try {
            if(addressService.deleteById(addressId)>0){
                return ResultVOUtil.success("根据ID删除收货地址成功");
            }
            return ResultVOUtil.error(1001, "根据ID删除收货地址失败");
        } catch (Exception e) {
            log.error("根据ID删除收货地址失败, {}", e.getMessage());
            return ResultVOUtil.error(1001, "根据ID删除收货地址失败");
        }
    }

    @PostMapping("/update")
    @ApiOperation("编辑收货地址")
    public ResultVo update(@RequestBody Address address){
        try {
            if(addressService.update(address)>0){
                return ResultVOUtil.success("编辑收货地址成功");
            }
            return ResultVOUtil.error(1001, "编辑收货地址失败");
        } catch (Exception e) {
            log.error("编辑收货地址失败, {}", e.getMessage());
            return ResultVOUtil.error(1001, "编辑收货地址失败");
        }
    }
}
