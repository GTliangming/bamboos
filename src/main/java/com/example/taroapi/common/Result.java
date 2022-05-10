package com.example.taroapi.common;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("响应返回实体")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result <T> {

    @ApiModelProperty("状态码")
    private  Integer code;
    @ApiModelProperty("描述信息")
    private  String msg;
    @ApiModelProperty("状态")
    private  Boolean status;
    @ApiModelProperty("响应实体数据")
    private  T data;

    @ApiModelProperty("token信息")
    private String token;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public static Result success() {
        Result result = new Result<>();
        result.setCode(200);
        result.setMsg("成功");
        result.setStatus(true);
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(data);
        result.setCode(200);
        result.setMsg("成功");
        result.setStatus(true);
        return result;
    }
    public static <T> Result<T> successByToken(T data,String token){
        Result<T> result = new Result<>(data);
        result.setCode(200);
        result.setMsg("成功");
        result.setToken(token);
        result.setStatus(true);
        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setStatus(false);
        return result;
    }
}
