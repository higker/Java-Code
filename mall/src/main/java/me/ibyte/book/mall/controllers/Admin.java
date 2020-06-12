package me.ibyte.book.mall.controllers;

import me.ibyte.book.mall.mappers.AdminMapper;
import me.ibyte.book.mall.models.Book;
import me.ibyte.book.mall.services.AdminService;
import me.ibyte.book.mall.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Admin控制器
 */
@Controller
@RequestMapping("/admin")
public class Admin {


    @Autowired
    AdminService adminService;

    @Autowired
    BookService bookService;

    @Autowired
    AdminMapper adminMapper;

    @GetMapping("/login")
    public String loginView() {
        return "admin-login";
    }

    @GetMapping("/main")
    public String list(Model md) {
        List<Book> books = bookService.allBook();
        md.addAttribute("list",books);
        return "admin-book-list";
    }
    @GetMapping("/main/add")
    public String add(Model md) {
        return "admin-add-book";
    }

    @PostMapping("/login")
    public String login(me.ibyte.book.mall.models.Admin admin, Model md) {
        me.ibyte.book.mall.models.Admin user = adminMapper.findUser(admin);
        if (user != null) {
            adminService.login(user);
            return "redirect:/admin/main";
        }
        md.addAttribute("msg","管理员账号或密码错误！！！");
        return "admin-login";
    }

    @PostMapping("/add/book")
    public String addBook(Book bk, Model md) {
        if (bk != null) {
            bookService.saveBook(bk);
            return "redirect:/admin/main";
        }
        md.addAttribute("msg","图书信息有误！！！");
        return "admin-add-book";
    }
}
