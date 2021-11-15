package com.sintoburi.config;

import com.sintoburi.auth.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author seongnamfc
 * @package com.sintoburi.config
 * @file InterceptorConfig
 * @description
 * @date 2021/11/06
 */
@Configuration
@EnableWebMvc
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authInterceptor()).order(0);
    }

//    @Bean
//    public AuthInterceptor authInterceptor() {
//        return new AuthInterceptor();
//    }

}
