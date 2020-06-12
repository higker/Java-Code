package me.ibyte.book.mall.controllers;

import me.ibyte.book.mall.mappers.UserMapper;
import me.ibyte.book.mall.models.Book;
import me.ibyte.book.mall.models.User;
import me.ibyte.book.mall.services.BookService;
import me.ibyte.book.mall.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


// 普通用户控制台
@Controller
@RequestMapping("/user")
public class Users {

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    HttpSession session;

    @GetMapping("/shop")
    public String support(Model md) {
        List<Book> shopList = (List<Book>) session.getAttribute("shop");
        if (shopList == null) {
            shopList = new ArrayList<Book>();
            session.setAttribute("shop", shopList);
        }
        BigDecimal total = new BigDecimal(0);
        for (Book b : shopList) {
            total = total.add(b.getMoney());
        }
        md.addAttribute("total", total);
        md.addAttribute("shop", shopList);
        return "user-shop-cart";
    }

    @GetMapping("/register")
    public String regView() {
        return "user-register";
    }


    @GetMapping("/login")
    public String loginView() {
        return "user-login";
    }

    @PostMapping("/register")
    public String reg(User user, Model md) {
        System.out.println(user.toString());
        if (checkEmail(user.getEmail()) && user.getPassword().getBytes().length >= 6) {
            if (userService.register(user)) {
                md.addAttribute("msg", "用户注册成功！请去登录！！");
            }
        } else {
            md.addAttribute("msg", "邮箱格式不合法或者密码长度小于6位！！！");
        }
        return "user-register";
    }

    @PostMapping("/login")
    public String login(User user, Model md) {
        System.out.println(user.toString());
        if (userService.login(user)) {
            return "redirect:/";
        }
        md.addAttribute("msg", "账户或者密码不正确！！！");
        return "user-login";
    }

    @GetMapping("/logout")
    public String logout() {
        session.removeAttribute("U");
        return "redirect:/";
    }

    public static boolean checkEmail(String email) {// 验证邮箱的正则表达式
        String format = "\\w+@{1}\\w+\\.{1}\\w+";
        //p{Alpha}:内容是必选的，和字母字符[\p{Lower}\p{Upper}]等价。如：200896@163.com不是合法的。
        //w{2,15}: 2~15个[a-zA-Z_0-9]字符；w{}内容是必选的。 如：dyh@152.com是合法的。
        //[a-z0-9]{3,}：至少三个[a-z0-9]字符,[]内的是必选的；如：dyh200896@16.com是不合法的。
        //[.]:'.'号时必选的； 如：dyh200896@163com是不合法的。
        //p{Lower}{2,}小写字母，两个以上。如：dyh200896@163.c是不合法的。
        if (email.matches(format)) {
            return true;// 邮箱名合法，返回true
        } else {
            return false;// 邮箱名不合法，返回false
        }
    }

    @GetMapping("/shop/add/{id}")
    public String addShopCart(Model md, @PathVariable String id) {
        List<Book> shopList = (List<Book>) session.getAttribute("shop");
        if (shopList == null) {
            shopList = new ArrayList<Book>();
            session.setAttribute("shop", shopList);
        }
        Book book = bookService.detailedBook(id);
        shopList.add(book);
        BigDecimal total = new BigDecimal(0);
        for (Book b : shopList) {
            total = total.add(b.getMoney());
        }
        md.addAttribute("total", total);
        md.addAttribute("shop", shopList);
        return "user-shop-cart";
    }

    @GetMapping("/surplus")
    public String surplus(String total, Model md) {
        if (total == null) {
            total = "0";
        }else{
            session.removeAttribute("shop");
        }
        User u = (User) session.getAttribute("U");
        userMapper.updatedMoney(new BigDecimal(total), Long.parseLong(u.getId().toString()));
        md.addAttribute("total", userMapper.getUser(u.getId().toString()).getSurplus());
        return "user-surplus";
    }

}
