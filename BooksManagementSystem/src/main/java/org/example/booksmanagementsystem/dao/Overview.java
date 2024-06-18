package org.example.booksmanagementsystem.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-13
 * Time: 11:36
 */
@Component
public class Overview {

    @Bean
    public UserDao getUseDao1() {
        return new UserDao();
    }
    @Bean
    public UserDao getUseDao2() {
        return new UserDao();
    }
}
