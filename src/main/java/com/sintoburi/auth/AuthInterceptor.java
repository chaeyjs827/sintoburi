package com.sintoburi.auth;

import com.google.common.net.HttpHeaders;
import com.sintoburi.util.UtilJwt;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UtilJwt utilJwt;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // jwt 토큰 검증 로직
        System.out.println("AuthInterceptor preHandle executed !!");

        String jwt = request.getHeader(HttpHeaders.AUTHORIZATION);
        System.out.println("[jwt] : " + jwt);

//        Claims claims = utilJwt.getClaimsByToken(jwt);
//        System.out.println("[id] : " + claims.getId());
//        System.out.println("[issuer] : " + claims.getIssuer());
//        System.out.println("[subject] : " + claims.getSubject());
//        System.out.println("[audience] : " + claims.getAudience());
//        System.out.println("[expiration] : " + claims.getExpiration());
//        System.out.println("[issuedAt] : " + claims.getIssuedAt());


        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

}
