package me.ibyte.book.mall.services;


import me.ibyte.book.mall.mappers.UserMapper;
import me.ibyte.book.mall.models.User;
import me.ibyte.book.mall.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    HttpSession httpSession;

    public boolean register(User user) {
        user.setCreateTime(TimeUtil.asDateToTimestamp());
        return userMapper.insertUser(user.getEmail(), user.getPassword(), user.getCreateTime());
    }

    public boolean login(User user) {
        User u = userMapper.findUser(user);
        if (u != null) {
            httpSession.setAttribute("U", u);
            return true;
        } else {
            return false;
        }
    }
}
