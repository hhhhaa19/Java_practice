package com.ben.mybatisplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-20
 * Time: 12:09
 */
@SpringBootApplication
@ComponentScan(value = {"com.ben.mybatisplus"})
public class MybatisPlusApplication {


    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }

}
