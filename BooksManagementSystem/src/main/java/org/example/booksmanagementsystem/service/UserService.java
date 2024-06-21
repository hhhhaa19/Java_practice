package org.example.booksmanagementsystem.service;

import cn.hutool.captcha.ICaptcha;
import jakarta.annotation.Resource;
import lombok.Getter;

import lombok.extern.slf4j.Slf4j;
import org.example.booksmanagementsystem.mapper.UserMapper;
import org.example.booksmanagementsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-12
 * Time: 13:14
 */
@Slf4j
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public String login(User user) {
        if (!StringUtils.hasLength(user.getUserName()) || !StringUtils.hasLength(user.getPassword())) {
            return "用户名或密码为空";
        }
        User userInfo = userMapper.selectUserByUserName(user.getUserName());
        if (userInfo == null) {
            return "未找到用户";
        }
        if (!userInfo.getPassword().equals(user.getPassword())) {
            return "密码错误";
        }
        return "登录成功";
    }


    public String registerUser(User user) {
        if (!StringUtils.hasLength(user.getUserName()) || !StringUtils.hasLength(user.getPassword())) {
            return "密码或用户名为空";
        }
        Integer i = userMapper.insertUser(user);
        if (i > 0) {
            return "注册成功";
        }
        log.info("注入数据库失败");
        return "注册失败，稍后再试";
    }
}
