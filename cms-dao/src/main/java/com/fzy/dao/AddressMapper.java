package com.fzy.dao;

import com.fzy.entity.Address;

import java.util.List;

/**
 * @program: AddressMapper
 * @description:
 * @author: fzy
 * @date: 2018-10-27 20:28
 **/
public interface AddressMapper {

    int save(Address address);

    List<Address> findAllByOpenId(String openId);

    Address findById(String addressId);

    int deleteById(String addressId);

    Address findByDefault(String openId);

    int updateDefault(String addressId);

    int update(Address address);
}
