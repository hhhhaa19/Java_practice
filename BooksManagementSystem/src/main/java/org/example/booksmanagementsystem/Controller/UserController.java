package org.example.booksmanagementsystem.Controller;

import cn.hutool.captcha.ICaptcha;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.booksmanagementsystem.component.ReCaptchaProperty;
import org.example.booksmanagementsystem.component.ReturnType;
import org.example.booksmanagementsystem.model.User;
import org.example.booksmanagementsystem.service.ReCaptchaService;
import org.example.booksmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-12
 * Time: 10:03
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ReCaptchaService reCaptchaService;
    @Autowired
    ReCaptchaProperty reCaptchaProperty;

    @RequestMapping("/login")
    public String login(User user) {
        log.info("接收到的用户参数{}",user);
        return userService.login(user);
    }

    @RequestMapping("/register")
    public String register(@RequestBody ReturnType<User,String> returnType, HttpSession httpSession) {
        //这里是spring mvc直接转了，我们也可以用string接受自己处理
        log.info("register信息{}", returnType);
        String code = (String) httpSession.getAttribute(reCaptchaProperty.getSession().getCode());
        Long time = (Long) httpSession.getAttribute(reCaptchaProperty.getSession().getTime());
        if (!reCaptchaService.verifyReCaptcha(code, returnType.getParameter(), time)){
            return "验证码错误或超时";
        }
        return userService.registerUser(returnType.getValue());
    }

    //这里是在control中处理还是在service
    @RequestMapping("/getReCaptcha")
    public void verify(HttpServletResponse httpServletResponse, HttpSession httpSession) {
        ICaptcha captcha = reCaptchaService.getReCaptcha();
        try (OutputStream outputStream = httpServletResponse.getOutputStream()) {
            captcha.write(outputStream);
            httpSession.setAttribute(reCaptchaProperty.getSession().getCode(), captcha.getCode());
            httpSession.setAttribute(reCaptchaProperty.getSession().getTime(), System.currentTimeMillis());
            log.info("发送验证码并设置session成功");
        } catch (IOException e) {
            log.error("验证码返回到前端失败", e);
            throw new RuntimeException(e);
        }
    }



}
