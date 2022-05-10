package com.example.taroapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

// 定时任务
@Configuration
public class ScheduleConfig {

    /**
     * fixedDelay 在上一次任务执行完成后，间隔多久再次执行
     * fixedRate  无论上次任务结束与否，两次任务的间隔时间
     * cron  使用corn表达式来指定任务计划
     */
//    @Scheduled(fixedRate = 3000)
//    public void  test(){
//        System.out.println("我是定时任务"+new Date());
//    }
}
