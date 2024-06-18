package org.example.booksmanagementsystem.dao;

import lombok.Data;
import lombok.Getter;
import org.example.booksmanagementsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-13
 * Time: 11:22
 */

@Component
public class UserDao {
    List<User> users;
    @Autowired
    @Getter
    User admin;

    public UserDao() {
        users = new ArrayList<User>();
    }

    public List<User> mock() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUserName("user" + i);
            user.setPassword("password" + i);
            users.add(user);
        }
        return users;
    }
}
