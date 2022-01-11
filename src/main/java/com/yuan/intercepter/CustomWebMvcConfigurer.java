package com.yuan.intercepter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置类
 */
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/api/v1/pri/**");

        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/api/v1/pri/**");

        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Bean
    public LoginInterceptor getLoginInterceptor() {
        return new LoginInterceptor();
    }
}
