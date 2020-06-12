package me.ibyte.book.mall.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object login_user = request.getSession().getAttribute("U");
        if (login_user == null || login_user.equals("")) {
            response.sendRedirect("/user/login");
            return false;
        }
        return true;
    }
}
