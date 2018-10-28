package com.fzy.service;

import com.fzy.entity.Address;
import com.fzy.entity.vo.AddressVo;

import java.util.List;

/**
 * @program: AddressService
 * @description:
 * @author: fzy
 * @date: 2018-10-27 21:20
 **/
public interface AddressService {

    int save(Address address) throws Exception;

    List<AddressVo> findAllByOpenId(String openId) throws Exception;

    AddressVo findById(String addressId) throws Exception;

    int deleteById(String addressId)throws Exception;

    int update(Address address) throws Exception;
}
