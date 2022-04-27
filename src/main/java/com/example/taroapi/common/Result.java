package com.example.taroapi.common;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result <T> {

    private  String code;
    private  String msg;
    private  Boolean status;
    private  T data;

    private String token;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public static Result success() {
        Result result = new Result<>();
        result.setCode("0");
        result.setMsg("成功");
        result.setStatus(true);
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(data);
        result.setCode("0");
        result.setMsg("成功");
        result.setStatus(true);
        return result;
    }
    public static <T> Result<T> successByToken(T data,String token){
        Result<T> result = new Result<>(data);
        result.setCode("0");
        result.setMsg("成功");
        result.setToken(token);
        result.setStatus(true);
        return result;
    }

    public static Result error(String code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setStatus(false);
        return result;
    }
}
