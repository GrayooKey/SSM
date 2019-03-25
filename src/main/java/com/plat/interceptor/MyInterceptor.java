package com.plat.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String sessionId = httpServletRequest.getRequestedSessionId();
        String requestURI = httpServletRequest.getRequestURI();         //统一资源标识符
        StringBuffer requestURL = httpServletRequest.getRequestURL();   //统一资源定位器
        System.out.println("请求映射路径：" + requestURI);
        System.out.println("执行拦截器的preHandle()方法");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("执行拦截器的postHandle()方法");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("执行拦截器的afterCompletion()方法");
    }
}
