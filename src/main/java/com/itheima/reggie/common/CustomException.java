package com.itheima.reggie.common;

/**
 * @Author yyzhou
 * @Date 2024/6/11 16:26
 * @PackageName:com.itheima.reggie.common
 * @ClassName: CustomException
 * @Description: 自定义异常类
 * @Version 1.0
 */
public class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }
}
