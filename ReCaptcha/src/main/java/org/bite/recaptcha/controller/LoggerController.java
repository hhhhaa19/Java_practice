package org.bite.recaptcha.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-17
 * Time: 0:30
 */
@Controller
@Slf4j//帮我们生成loggerduox
@RequestMapping("/logger")
public class LoggerController {
    //public static Logger logger = LoggerFactory.getLogger(LoggerController.class);
    @RequestMapping("/printLog")
    public void printLog() {
        log.info("This is a log message");
    }
}
