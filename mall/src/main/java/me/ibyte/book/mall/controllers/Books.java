package me.ibyte.book.mall.controllers;

import me.ibyte.book.mall.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


// 图书控制器
@Controller
@RequestMapping("/")
public class Books {

    @Autowired
    BookService bs;

    @GetMapping(value = {"/","/books"})
    public String view(Model md){
        md.addAttribute("list",bs.allBook());
        return "books-list";
    }

    @GetMapping("/books/{id}")
    public String detailed(@PathVariable String id, Model md){
        md.addAttribute("bk",bs.detailedBook(id));
        return "books-detailed";
    }

    @GetMapping("/books/search")
    public String search(@RequestParam String key, Model md){
        md.addAttribute("list",bs.searchBook(key));
        return "books-list";
    }

}
