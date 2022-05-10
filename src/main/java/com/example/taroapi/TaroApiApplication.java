package com.example.taroapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync  // 异步任务注解
@EnableScheduling  // 定时任务注解
@SpringBootApplication
@MapperScan("com.example.taroapi.mapper")
public class TaroApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaroApiApplication.class, args);
    }

}
