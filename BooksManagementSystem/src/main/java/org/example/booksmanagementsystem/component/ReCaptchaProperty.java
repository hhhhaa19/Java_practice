package org.example.booksmanagementsystem.component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-21
 * Time: 10:55
 */
@Component
@ConfigurationProperties("captcha")
@Data
public final class ReCaptchaProperty {
    private Integer width;
    private Integer height;
    private Integer codeCount;
    private Long validTime;
    private Session session;

    @Data
    public static class Session {
        private String code;
        private String time;
    }
}
