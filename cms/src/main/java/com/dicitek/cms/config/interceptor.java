package com.dicitek.cms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class interceptor implements WebMvcConfigurer {
    /**
     * 不需要登录拦截的url
     */
    private final String[] notLoginInterceptPaths = {"/", "/index.html", "/about", "/support", "/news", "/admin/booking/add", "/static/**","/admin/login","/admin/tologin"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdmIninterceptor()).addPathPatterns("/admin/**").excludePathPatterns(notLoginInterceptPaths);
    }
}
