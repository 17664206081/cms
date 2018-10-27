package com.fzy.dao;

import com.fzy.entity.MajorProduct;

import java.util.List;

/**
 * @program: MajorProductMapper
 * @description:
 * @author: fzy
 * @date: 2018-10-25 18:37
 **/
public interface MajorProductMapper {

    int save(MajorProduct majorProduct);

    List<MajorProduct> findAll();

    int delete(String majorId);
}
