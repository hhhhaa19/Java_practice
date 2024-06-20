package org.ben.mybatisexpansion.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-20
 * Time: 12:26
 */
@SpringBootTest
class UserinfoMapperTest {

    @Autowired
    UserinfoMapper userinfoMapper;

    @Test
    void deleteByPrimaryKey() {
        userinfoMapper.deleteByPrimaryKey(5);
    }
    @Test
    void insertSelective() {
        System.out.println(userinfoMapper.selectById(2));
    }
}