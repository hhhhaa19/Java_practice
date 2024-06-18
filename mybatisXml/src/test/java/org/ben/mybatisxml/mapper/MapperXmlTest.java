package org.ben.mybatisxml.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}