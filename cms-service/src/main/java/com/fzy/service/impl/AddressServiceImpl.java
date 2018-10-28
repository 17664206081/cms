package com.fzy.service.impl;

import com.fzy.dao.AddressMapper;
import com.fzy.entity.Address;
import com.fzy.entity.enums.AddressEnum;
import com.fzy.entity.enums.ResultEnum;
import com.fzy.entity.vo.AddressVo;
import com.fzy.exception.ServiceException;
import com.fzy.service.AddressService;
import com.fzy.utils.UUIDUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: AddressImpl
 * @description:
 * @author: fzy
 * @date: 2018-10-27 21:21
 **/
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public int save(Address address) throws Exception {
        address.setAddressId(UUIDUtil.createUUID());
        Address addr = addressMapper.findByDefault(address.getOpenId());
        if(null==addr){
            address.setIsDefault(AddressEnum.DEFAULT.getCode());
        }else{
            address.setIsDefault(AddressEnum.NO_DEFAULT.getCode());
        }
        return addressMapper.save(address);
    }

    @Override
    public List<AddressVo> findAllByOpenId(String openId) throws Exception {
        List<AddressVo> res= new ArrayList<>();
        List<Address> list = addressMapper.findAllByOpenId(openId);
        for (Address address : list) {
            AddressVo addressVo=new AddressVo();
            BeanUtils.copyProperties(address,addressVo);
            res.add(addressVo);
        }
        return res;
    }

    @Override
    public AddressVo findById(String addressId) throws Exception {
        Address address = addressMapper.findById(addressId);
        AddressVo addressVo=new AddressVo();
        BeanUtils.copyProperties(address,addressVo);
        return addressVo ;
    }

    @Override
    public int deleteById(String addressId) throws Exception {
        Address address = addressMapper.findById(addressId);
        if(null==address){
            throw new ServiceException(ResultEnum.ADDRESS_NOT_EXIST);
        }

        if(address.getIsDefault().intValue()==AddressEnum.DEFAULT.getCode().intValue()){
            List<Address> list = addressMapper.findAllByOpenId(address.getOpenId());
            if(list.size()>1){
                addressMapper.updateDefault(list.get(1).getAddressId());
            }
        }
        return addressMapper.deleteById(addressId);
    }

    @Override
    public int update(Address address) throws Exception {
        return addressMapper.update(address);
    }
}
