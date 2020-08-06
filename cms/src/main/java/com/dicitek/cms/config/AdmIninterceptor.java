package com.dicitek.cms.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdmIninterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object login_user = request.getSession().getAttribute("oklogin");
        if (login_user == null || login_user.equals("")) {
            response.sendRedirect("/admin/login");
            return false;
        }
        return true;
    }
}


