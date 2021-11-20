package com.sintoburi.auth;

import com.google.common.net.HttpHeaders;
import com.sintoburi.util.UtilJwt;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

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

    @Autowired
    private UtilJwt utilJwt;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // HandlerMethod 타입 체크
        if(handler instanceof HandlerMethod == false) {
            return true;
        }

        // 형 변환
        HandlerMethod handlerMethod = (HandlerMethod)handler;

        // @AuthRequired 객체 불러오기
        AuthRequired auth = handlerMethod.getMethodAnnotation(AuthRequired.class);

        // method에 @AuthRequired 가 없는 경우
        if(auth == null) {
            return true;
        }

        // jwt 토큰 검증 로직
        System.out.println("AuthInterceptor preHandle executed !!");

        String jwt = request.getHeader(HttpHeaders.AUTHORIZATION);
        System.out.println("[jwt] : " + jwt);

        // JWT 유효성 검사
        utilJwt.testAuthenticateByToken(jwt);


//        System.out.println("authenticate result : " + utilJwt.authenticateByToken(jwt));

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

}
