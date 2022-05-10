package com.example.taroapi.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Async
    public void test(){
        try {
            Thread.sleep(3000);
            System.out.println("我是异步任务");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
