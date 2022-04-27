package com.example.taroapi.interceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.taroapi.entity.User;
import com.example.taroapi.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Jwt 拦截器
 */
public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception{
        String token = request.getHeader("token");
        if(!(handle instanceof HandlerMethod)){
            return true;
        }
        System.out.println("--------token");
        System.out.println(token);
        //执行认证
        if(StrUtil.isBlankIfStr(token)){
            throw new RuntimeException("无token信息,请重新登录！");
        }
        //获取token中的userID
        String userID;
        try{
            userID = JWT.decode(token).getAudience().get(0);
        }catch (JWTDecodeException j){
            throw new RuntimeException("token 验证失败");
        }
        User user = userMapper.selectById(userID);
        if(user == null){
            throw new RuntimeException("该用户不存在！");
        }
        //用户密码加签验证token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getUsername())).build();
        try{
            jwtVerifier.verify(token);
        }catch (JWTVerificationException j){
            throw new RuntimeException("token 验证失败");
        }
        return true;
    }
}
