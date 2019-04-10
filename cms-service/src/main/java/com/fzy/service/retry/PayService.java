package com.fzy.service.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @program: PayService
 * @description:
 * @author: fzy
 * @date: 2019-04-10 10:57
 **/
@Slf4j
@Service
public class PayService {

    @Retryable(value = Exception.class, backoff = @Backoff(delay = 2000))
    public int toPayMoney() throws Exception{
        log.info("我正在模拟向银行强求扣钱 time={}",System.currentTimeMillis());
        throw new IOException("网络不佳请重试!!!");
    }

}
