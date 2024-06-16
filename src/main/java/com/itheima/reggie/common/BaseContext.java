package com.itheima.reggie.common;

/**
 * @Author yyzhou
 * @Date 2024/6/11 10:44
 * @PackageName:com.itheima.reggie.common
 * @ClassName: BaseContext
 * @Description: 基于ThreadLocal封装的工具类，用户保存和获取当前登录用户id
 * @Version 1.0
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal=new ThreadLocal<>();

    public static void setThreadLocal(Long id){
        threadLocal.set(id);
    }

    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
