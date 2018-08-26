package com.example.demo.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
       //判断用户使用登录，如果登录-> 放行，否则拦截并跳转到登录页面
        HttpSession session = request.getSession();
        if(session.getAttribute("member") != null){
            return true;
        }else{
            response.sendRedirect("/account");
            return false;
        }
    }
}
