package com.fzy.service;

import java.util.concurrent.Future;

/**
 * @program: AsyncService
 * @description:
 * @author: fzy
 * @date: 2019-02-07 14:00
 **/
public interface AsyncService {

    Future<Integer> add(int a, int b);
}
