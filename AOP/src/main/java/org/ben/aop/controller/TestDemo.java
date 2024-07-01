package org.ben.aop.controller;

import org.ben.aop.proxy.MyAnnotation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-25
 * Time: 1:10
 */
@RestController
public class TestDemo {
    @RequestMapping("/t1")
    public String test1() {
        return "t1";
    }

    @RequestMapping("/t2")
    @MyAnnotation
    public String test2() {
        return "t2";
    }
}
