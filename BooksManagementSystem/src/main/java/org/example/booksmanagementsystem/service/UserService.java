package org.example.booksmanagementsystem.service;

import jakarta.annotation.Resource;
import lombok.Getter;
import org.example.booksmanagementsystem.dao.UserDao;
import org.example.booksmanagementsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-12
 * Time: 13:14
 */
@Component
public class UserService {
    @Autowired
    @Getter
    UserDao userDao;

    public Boolean login(User user) {
        if (!StringUtils.hasLength(user.getUserName()) || !StringUtils.hasLength(user.getPassword())) {
            return false;
        }
        if ("benjamin".equals(user.getUserName()) && "123456".equals(user.getPassword())) {
            return true;
        }
        return false;
    }

    public User getUser() {
        return userDao.getAdmin();
    }
}
