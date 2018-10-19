package com.fzy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: CmsApplication
 * @description:
 * @author: fzy
 * @date: 2018-10-13 18:09
 **/
@SpringBootApplication
@MapperScan("com.fzy.dao")
@ServletComponentScan
@EnableSwagger2
//@EnableScheduling
public class CmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }
}
