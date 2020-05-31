package me.ibyte.pcb.mall.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ Author: Ding <br/>
 * @ Version: V1.0
 * @ Notes: 程序主启动类
 * <p>
 * Created with IDEA. Date：2020/5/31 7:11 下午
 * <a href="https://github.com/higker">Github Home Page</a>
 * </p>
 */
@Controller
@RequestMapping("/")
public class product {

    @GetMapping(value = {"/","/product"})
    public String product(){
        return "product";
    }
}
