package com.fzy.service;

import com.fzy.entity.MajorProduct;

import java.util.List;

/**
 * @program: MajorProductService
 * @description:
 * @author: fzy
 * @date: 2018-10-25 18:47
 **/
public interface MajorProductService {

    int save(String productId) throws Exception;

    int delete(String majorId) throws Exception;

    List<MajorProduct> findAll() throws Exception;
}
