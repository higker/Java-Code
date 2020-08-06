package com.dicitek.cms.controller;

import com.dicitek.cms.mapper.productService;
import com.dicitek.cms.mapper.sysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ Author: Ding <br/>
 * @ Version: V1.0
 * @ Notes: 主页控制器
 * <p>
 * Created with IDEA. Date：2020/7/15 5:52 下午
 * <a href="https://github.com/higker">Github Home Page</a>
 * </p>
 */
@RequestMapping("/")
@Controller
public class indexController {

    @Autowired
    productService ps;

    @Autowired
    sysService ss;

    @GetMapping(value = {"index.html", "/"})
    public String Index(Model ui) {
        // System.out.println(ps.getAll());
        ui.addAttribute("product", ps.getAll());
        ui.addAttribute("sys", ss.getInfo());
        return "index";
    }

    @GetMapping("/support")
    public String Support(Model ui) {
        ui.addAttribute("sys", ss.getInfo());
        return "support";
    }

    @GetMapping("/about")
    public String About(Model ui) {
        ui.addAttribute("sys", ss.getInfo());
        return "about";
    }
}
