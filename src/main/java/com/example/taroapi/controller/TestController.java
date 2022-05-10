package com.example.taroapi.controller;

import com.example.taroapi.listener.TestEvent;
import com.example.taroapi.service.TestService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;



@Api(tags = "测试",description = "测试实体以及一些巴拉巴拉的") // swagger注解
@Slf4j
@Controller
@RequestMapping()
public class TestController {

    @Resource
    TestService testService;

    @Resource
    ApplicationContext context;

    @ApiOperation("访问测试页面")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功"),
            @ApiResponse(code = 500,message = "失败"),
    })
    @GetMapping("/test")
    public String testPage(@ApiParam("姓名") @RequestParam("name") String name){
//        testService.test();
        log.info("访问了测试页面");
        return "index";
    }

    @ApiIgnore  // 忽略Swagger扫描
    @ApiOperation("访问测试监听器")
    @GetMapping("/testevent")
    public String testEvent(HttpServletRequest request){
        context.publishEvent(new TestEvent("有人在测试监听器"));
        return "index";
    }

}
