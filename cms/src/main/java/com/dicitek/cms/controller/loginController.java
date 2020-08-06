package com.dicitek.cms.controller;


import com.dicitek.cms.mapper.userService;
import com.dicitek.cms.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class loginController {

    @Autowired
    userService us;

    @Autowired
    HttpServletRequest request;


    @RequestMapping(value = "/tologin")
    public String login(String username, String password, Model ui) {
        if (username == null || password == null) {
            ui.addAttribute("msg", "密码和账号不能为空!");
            return "forward:/admin/login";
        }
        System.out.println(username + ";" + password);
        user login = us.login(username, password);
        if (login != null) {
            request.getSession().setAttribute("oklogin", login);
            return "redirect:/admin/product";
        }
        ui.addAttribute("msg", "密码或者账号错误!");
        return "forward:/admin/login";
    }
}
