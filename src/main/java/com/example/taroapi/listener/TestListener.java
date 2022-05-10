package com.example.taroapi.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


/**
 * 监听器 （当某个事件发生时自动触发监听器）
 */
@Component
public class TestListener implements ApplicationListener<TestEvent> {

    @Override
    public void onApplicationEvent(TestEvent event) {
        System.out.println("事件触发了："+event.getSource());
    }
}
