package com.example.taroapi.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("taro_user")
public class User {
    /**
     * IdType 类型含义
     * AUTO 自动增长
     * ID_WORKER mybatis-plus 自带策略 生成19位值
     * ID_WORKER_STR  与上面类似,只单独针对string
     * INPUT 没有策略 需要自己设定ID
     * None 没有策略
     * UUID 自动生成随机数
     */
    @TableId(type = IdType.AUTO)
    private  Long id;
    private  String username;


    /**
     *添加自动填充的注解
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private  Date updateTime;
}
