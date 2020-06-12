package me.ibyte.book.mall.services;

import me.ibyte.book.mall.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AdminService {


    @Autowired
    HttpSession httpSession;

    public void login(Admin admin){
        httpSession.setAttribute("A",admin);
    }
}
