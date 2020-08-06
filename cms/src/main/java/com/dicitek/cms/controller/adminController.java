package com.dicitek.cms.controller;


import com.dicitek.cms.mapper.bookingService;
import com.dicitek.cms.mapper.productService;
import com.dicitek.cms.mapper.userService;
import com.dicitek.cms.model.booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/")
public class adminController {


    private List<booking> bookingList = new ArrayList<>();

    @Autowired
    productService ps;

    @Autowired
    bookingService ks;



    @RequestMapping("/login")
    public String loginView() {
        return "login";
    }

    @GetMapping("/product")
    public String productView(Model ui) {
        ui.addAttribute("pss", ps.getAll());
        return "product";
    }

    @GetMapping("/booking")
    public String bookingView(Model ui) {
        ui.addAttribute("bks", ks.getAll());
        return "booking";
    }

    @GetMapping("/booking/del")
    public String bookingDelView(Model ui, int id) {
        ks.delete(id);
        ui.addAttribute("bks", ks.getAll());
        return "booking";
    }

    @GetMapping("/product/add")
    public String productAddView(Model ui) {
        return "add";
    }

    @PostMapping("/product/add")
    public String productAdd(Model ui, String name, String imgUrl) {
        ps.insert(name, imgUrl);
        ui.addAttribute("pss", ps.getAll());
        return "product";
    }

    @PostMapping("/booking/add")
    public String bookingAdd(String phone, String message) {
        if (phone == null || message == null) {
            return "redirect:/";
        }
        bookingList.add(new booking(phone, message));
        new Thread() {
            @Override
            public void run() {
                System.out.println("开始了");
                try {
                    Thread.sleep(1000 * 15L);
                } catch (InterruptedException e) {
                    bookingList.clear();
                    e.printStackTrace();
                }
                bookingList.clear();
                System.out.println("处理完了");
            }
        }.start();
        ks.insert(phone, message);
        return "redirect:/";
    }

    @ResponseBody
    @GetMapping("/booking/order")
    public String checkOrder() {
        if (bookingList.size() > 0) {
            return "true";
        }
        return "false";
    }

    @GetMapping("/product/del")
    public String productDelView(Model ui, int id) {
        ps.delete(id);
        ui.addAttribute("pss", ps.getAll());
        return "product";
    }
}
