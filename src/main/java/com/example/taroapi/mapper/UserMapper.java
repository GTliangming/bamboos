package com.example.taroapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.taroapi.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {

    @Select("select password from user where username=#{username}")
    User selectByName(String username);
}
