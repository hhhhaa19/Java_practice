package org.bite.recaptcha.controller;

import cn.hutool.captcha.CircleCaptcha;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.bite.recaptcha.component.ReCaptchaProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStream;
import java.security.Timestamp;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-15
 * Time: 16:53
 */
@RequestMapping("/captcha")
@RestController
public class CaptchaController {
    public static final Long TIME_DELTA = 60 * 1000L;
    @Autowired
    public ReCaptchaProperties reCaptchaProperties;

    @RequestMapping("/getCaptcha")
    public void getCaptcha(HttpServletResponse response, HttpSession session) {
        CircleCaptcha captcha = new CircleCaptcha(reCaptchaProperties.getWidth(), reCaptchaProperties.getHeight(), reCaptchaProperties.getCodeCount());
        session.setAttribute(reCaptchaProperties.getSession().getCode(), captcha.getCode());
        session.setAttribute(reCaptchaProperties.getSession().getTime(), new Date());
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        try (OutputStream out = response.getOutputStream()) {
            captcha.write(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/check")
    public Boolean checkCaptcha(HttpSession session, String captchaCode) {
        String sessionCode = (String) session.getAttribute(reCaptchaProperties.getSession().getCode());
        Date sessionTime = (Date) session.getAttribute(reCaptchaProperties.getSession().getTime());
        if (sessionCode == null) {
//            System.out.println("the captcha_code is null");
            return false;
        }
        Date now = new Date();
        if (( now.getTime()-sessionTime.getTime()) > TIME_DELTA){
            return false;
        }
        return sessionCode.equalsIgnoreCase(captchaCode);
    }
}
