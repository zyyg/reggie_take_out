package com.itheima.reggie.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @Author yyzhou
 * @Date 2024/5/25 22:38
 * @PackageName:com.itheima.reggie.common
 * @ClassName: GlobalExceptionHandler
 * @Description: 全局异常处理
 * @Version 1.0
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 异常处理方法
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionHandle(SQLIntegrityConstraintViolationException exception){
        if(exception.getMessage().contains("Duplicate entry")){
            String[] split=exception.getMessage().split(" ");
            String msg=split[2]+"已存在";
            return R.error(msg);

        }
        log.error(exception.getMessage());
        return R.error("失败了");
    }

    @ExceptionHandler(CustomException.class)
    public R<String> exceptionHandle(CustomException exception){
        log.error(exception.getMessage());
        return R.error(exception.getMessage());
    }
}
