package me.ibyte.pcb.mall.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ Author: Ding <br/>
 * @ Version: V1.0
 * @ Notes: 计算控制器
 * <p>
 * Created with IDEA. Date：2020/5/31 12:15 下午
 * <a href="https://github.com/higker">Github Home Page</a>
 * </p>
 */
@Controller
@RequestMapping("compute/")
public class compute {

    @GetMapping("view")
    public String view(){
        return "compute";
    }
}
