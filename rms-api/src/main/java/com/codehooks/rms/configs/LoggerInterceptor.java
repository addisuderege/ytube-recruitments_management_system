package com.codehooks.rms.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerClientInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoggerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) {
        System.out.println("============================ REQUEST-START =====================================");
        System.out.println("URL\t\t\t : " + request.getRequestURI());
        System.out.println("METHOD\t\t : " + request.getMethod());
        return true;
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception ex) {
        System.out.println("============================ REQUEST-START =====================================");
        System.out.println("Status\t\t\t : " + response.getStatus());
        System.out.println("Headers\t\t : " + response.getHeaders("Accept"));
    }
}
