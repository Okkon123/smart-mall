package com.cqu.cs.mall.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在请求处理之前进行操作
        String userInfo = request.getHeader("token"); // 假设用户信息在请求头中
        if (userInfo == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false; // 拦截请求
        }

        // 可以将用户信息存储在请求属性中，以便后续使用
        request.setAttribute("userInfo", userInfo);

        return true; // 继续处理请求
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 请求处理之后但在视图渲染之前进行操作
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 在请求完成后进行操作，即在视图渲染之后
    }
}