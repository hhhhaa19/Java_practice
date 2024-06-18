package org.bite.recaptcha.controller;

import org.bite.recaptcha.mapper.UserMapper;
import org.bite.recaptcha.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-17
 * Time: 23:34
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("register")
    public String registerUser(UserInfo userInfo) {
        userMapper.insertUser(userInfo);
        return "Register "+ userInfo.getId()+" successful";
    }
    @RequestMapping("/showAllUsers")
    public List<UserInfo> showAllUsers() {
        return userMapper.getUsers();
    }
}
