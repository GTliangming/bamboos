package com.example.taroapi.controller;

import com.example.taroapi.common.Result;
import com.example.taroapi.entity.User;
import com.example.taroapi.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserMapper userMapper;

    @GetMapping("/list")
    public Result<?> getUserList(){
        List<User> users= userMapper.selectList(null);
        return Result.success(users);
    }

}
