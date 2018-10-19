package com.fzy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @program: ScheduledController
 * @description:
 * @author: fzy
 * @date: 2018-10-18 10:31
 **/
@Component
@Slf4j
public class ScheduledController {

    @Scheduled(cron = "0/5 * * * * *")
    public void scheduled(){
        log.info("=====>>>>>使用cron  {}",System.currentTimeMillis());
    }

}
