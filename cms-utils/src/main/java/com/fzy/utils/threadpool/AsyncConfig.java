package com.fzy.utils.threadpool;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: AsyncConfig
 * @description: 异步线程池
 * @author: fzy
 * @date: 2019-02-07 12:15
 **/
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    @Bean("taskExecutor")
    @Override
    public Executor getAsyncExecutor() {
        //线程池
        ThreadPoolTaskExecutor task=new ThreadPoolTaskExecutor();
        //配置核心线程数
        task.setCorePoolSize(5);
        //配置最大线程数
        task.setMaxPoolSize(10);
        //配置队列大小
        task.setQueueCapacity(25);
        //执行初始化
        task.initialize();
        return task;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
