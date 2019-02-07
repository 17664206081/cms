package com.fzy.service.impl;

import com.fzy.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @program: AsynServiceImpl
 * @description:
 * @author: fzy
 * @date: 2019-02-07 14:01
 **/
@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService {

    @Async("taskExecutor")
    @Override
    public Future<Integer> add(int a, int b) {
        log.info("开始计算.....");
        return new AsyncResult<>(a+b);
    }

}
