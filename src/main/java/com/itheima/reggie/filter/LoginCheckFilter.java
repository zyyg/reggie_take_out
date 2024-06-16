package com.itheima.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.itheima.reggie.common.BaseContext;
import com.itheima.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author yyzhou
 * @Date 2024/5/25 21:32
 * @PackageName:com.itheima.reggie.filter
 * @ClassName: LoginCheckFilter
 * @Description: 检查用户是否已经完成登录
 * @Version 1.0
 */
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {

    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1、获取本次请求的URL
        String requestURI = request.getRequestURI();
        log.info("拦截到请求：{}",request.getRequestURI());
        //2、判断本次请求是否需要被处理
        //不需要处理的路径
        String[] urls=new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**",
                "/user/sendMsg",
                "/user/login"
        };

        //3、如果不需要处理，则直接放行
        boolean check = check(urls, requestURI);
        if(check){
            log.info("本次请求{}不需要处理",requestURI);
            filterChain.doFilter(request,response);
            return;
        }

        //4-1、判断登录状态，如果已经登录，则放行
        if(request.getSession().getAttribute("employee")!=null){
            log.info("用户已登录，用户id为{}",request.getSession().getAttribute("employee"));

            Long empId = (Long) request.getSession().getAttribute("employee");
            BaseContext.setThreadLocal(empId);
//            long id=Thread.currentThread().getId();
//            log.info("线程id为：{}",id);
            filterChain.doFilter(request,response);
            return;
        }

        //4-2、判断移动端是否登录状态，如果已经登录，则放行
        if(request.getSession().getAttribute("user")!=null){
            log.info("用户已登录，用户id为{}",request.getSession().getAttribute("user"));

            Long userId = (Long) request.getSession().getAttribute("user");
            BaseContext.setThreadLocal(userId);
//            long id=Thread.currentThread().getId();
//            log.info("线程id为：{}",id);
            filterChain.doFilter(request,response);
            return;
        }

        //5、如果未登录返回未登录页面，通过输出流方式向客户端页面响应数据
        log.info("用户未登录");
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;
    }

    /**
     * 检查本次路径是否需要放行
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls, String requestURI){
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if(match){
                return true;
            }
        }
        return false;
    }
}
