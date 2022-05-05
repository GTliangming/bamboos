package com.example.taroapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping()
public class TestController {

    @GetMapping("/test")
    public String testPage(HttpServletRequest request){
        MDC.put("reqID",request.getSession().getId());
        log.info("访问了测试页面");
        return "index";
    }
}
