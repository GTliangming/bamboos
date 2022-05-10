package com.example.taroapi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.taroapi.common.Result;
import com.example.taroapi.common.Utils.TokenUtils;
import com.example.taroapi.entity.User;
import com.example.taroapi.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(tags = "用户相关接口",description = "用户登录注册验证等一系列相关接口") // swagger注解
@RestController
@RequestMapping("/api/user")
@Validated
public class UserController {

    @Resource
    UserMapper userMapper;

    @ApiOperation("获取用户列表")
    @GetMapping("/list")
    public Result<?> getUserList() {
        String id = TokenUtils.getIdByToken();
        User users = userMapper.selectById(id);
        return Result.success(users);
    }

    @ApiOperation("管理后台登录")
    @PostMapping("/admin_login")
    public Result<?> adminLogin(@RequestBody User userParam) {
        // 查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userParam.getUsername());
        queryWrapper.eq("password", userParam.getPassword());
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            return Result.error(400, "用户名或密码错误");
        }
        if (user.getRule() != 0 && user.getRule() != 1) {
            return Result.error(400, "当前用户权限不足");
        }
        String token = TokenUtils.getToken(user.getId().toString(), user.getPassword());
        return Result.successByToken(user, token);
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public Result<?> userRegister(@RequestBody User userParam) {
        // 新建查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 先判断用户名的唯一性
        queryWrapper.eq("username", userParam.getUsername());
        User res = userMapper.selectOne(queryWrapper);
        if (res != null) {
            return Result.error(400, "该用户已注册");
        }
        if (userParam.getPassword() == null) {
            userParam.setPassword("123456");
        }
        userMapper.insert(userParam);
        User newUser = userMapper.selectOne(queryWrapper);
        String token = TokenUtils.getToken(newUser.getId().toString(), newUser.getPassword());
        return Result.successByToken(newUser, token);
    }

}
