package com.fzy;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.retry.annotation.EnableRetry;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: CmsApplication
 * @description:
 * @author: fzy
 * @date: 2018-10-13 18:09
 **/

@MapperScan("com.fzy.dao")
@ServletComponentScan
@EnableSwagger2
@SpringBootApplication
@Slf4j
@EnableRetry
//@EnableScheduling
public class CmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
        log.info("-- 启动完成--");
    }
}
