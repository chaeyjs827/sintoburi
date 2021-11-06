package com.sintoburi.auth;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author seongnamfc
 * @package com.sintoburi.auth
 * @file AuthInterceptor
 * @description
 * @date 2021/11/05
 */
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // jwt 토큰 검증 로직
        System.out.println("AuthInterceptor preHandle executed !!");

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

}
