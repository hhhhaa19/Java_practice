package org.bite.recaptcha.component;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-15
 * Time: 18:05
 */
@ConfigurationProperties("captcha")
@Component
@Data
public class ReCaptchaProperties {
    private Integer width;
    private Integer height;
    private Integer codeCount;
    private Session session;

    @Data
    public static class Session {
        private String code;
        private String time;
    }

}
