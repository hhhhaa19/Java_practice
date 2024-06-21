package org.example.booksmanagementsystem.service;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ICaptcha;
import lombok.extern.slf4j.Slf4j;
import org.example.booksmanagementsystem.component.ReCaptchaProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-21
 * Time: 10:38
 */
@Slf4j
@Service
public class ReCaptchaService {
    @Autowired
    private ReCaptchaProperty reCaptchaProperty;

    public Boolean verifyReCaptcha(String code, String inputCode, Long time) {
        log.info("生成的验证码：{}，接受的验证码：{}", code, inputCode);
        if (!StringUtils.hasLength(inputCode)
                || !StringUtils.hasLength(code)) {
            return false;
        }
        if (!code.equalsIgnoreCase(inputCode)) {
            return false;
        }
        Long timeDelta = System.currentTimeMillis() - time;
        if (timeDelta > reCaptchaProperty.getValidTime()) {
            return false;
        }
        return true;
    }

    public ICaptcha getReCaptcha() {
        return CaptchaUtil.createCircleCaptcha(reCaptchaProperty.getWidth(),
                reCaptchaProperty.getHeight(), reCaptchaProperty.getCodeCount(), reCaptchaProperty.getCodeCount());
    }

}
