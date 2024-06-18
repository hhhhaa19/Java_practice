package org.bite.recaptcha.mapper;

import org.bite.recaptcha.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-18
 * Time: 23:41
 */
@SpringBootTest
class xmlMapperTest {
    @Autowired
    xmlMapper mapper;

    @Test
    void count() {
        int count = mapper.count();
    }

    @Test
    void insertUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("username");
        userInfo.setPassword("password");
        userInfo.setAge(1);
        userInfo.setGender(1);
        userInfo.setPhoneNumber("11111111");
        mapper.insertUserInfo(userInfo);
    }

    @Test
    void getUserInfo() {
        System.out.println(mapper.getUserInfo());
    }

    @Test
    void selectUserInfoByArticleId() {
        System.out.println(mapper.selectUserInfoByArticleId());
    }
}