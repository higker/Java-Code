package me.ibyte.book.mall.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class ViewInterceptor implements WebMvcConfigurer {
    /**
     * 不需要登录拦截的url
     */
    private final String[] notLoginInterceptPaths = {"/","/books/", "/user/login", "/user/register","/admin/login","/static/**"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdmIninterceptor()).addPathPatterns("/admin/**").excludePathPatterns(notLoginInterceptPaths);
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/user/**").excludePathPatterns(notLoginInterceptPaths);
    }
}
