package com.sintoburi.config.filter;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author seongnamfc
 * @package com.sintoburi.config.filter
 * @file JwtAuthenticationFilter
 * @description
 * @date 2021/11/13
 */
public class JwtAuthenticationFilter  extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }
}
