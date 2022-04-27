package com.example.taroapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.taroapi.mapper")
public class TaroApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaroApiApplication.class, args);
    }

}
