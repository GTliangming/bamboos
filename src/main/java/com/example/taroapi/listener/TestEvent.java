package com.example.taroapi.listener;

import org.springframework.context.ApplicationEvent;

/**
 * 测试事件
 */
public class TestEvent extends ApplicationEvent {
    public TestEvent(Object source) {
        super(source);
    }
}
