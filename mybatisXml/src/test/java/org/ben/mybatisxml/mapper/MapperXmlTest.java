package org.ben.mybatisxml.mapper;

import org.apache.ibatis.annotations.Delete;
import org.ben.mybatisxml.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-18
 * Time: 22:59
 */
@SpringBootTest
class MapperXmlTest {
    @Autowired
    MapperXml mapperXml;

    @Test
    void selectCount() {
        mapperXml.selectCount();
    }

    @Test
    void insertByCondition() {
        UserInfo u = new UserInfo();
        u.setUsername("bill");
        u.setPassword("123456");
        u.setAge(18);
        //u.setGender(23);
        mapperXml.insertByCondition(u);
    }

    @Test
    void updateByCondition() {
        UserInfo u = new UserInfo();
        u.setUsername("ben");
        u.setPassword("10");
 //       u.setAge(10);
        u.setId(10);
        u.setGender(23);
        mapperXml.updateByCondition(u);
    }

    @Test
    void selectByIds() {
        UserInfo u1 = new UserInfo();
        u1.setId(1);
        UserInfo u2 = new UserInfo();
        u2.setId(3);
        UserInfo u3 = new UserInfo();
        u3.setId(5);
        UserInfo[] us = new UserInfo[] {u1, u2, u3};
        List<UserInfo> list = mapperXml.selectByIds(new ArrayList<UserInfo>(Arrays.asList(us)));
    }
}