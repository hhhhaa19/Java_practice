package org.example.booksmanagementsystem.component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-22
 * Time: 16:34
 */
@Component
@Data
@ConfigurationProperties("session")
public class Session {
    private String code;
    private String time;
    private String userInfo;

}
