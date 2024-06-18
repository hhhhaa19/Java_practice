package org.example.booksmanagementsystem.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-12
 * Time: 10:04
 */
@Data
@ConfigurationProperties(prefix = "user")
@Component
public class User {
    private String userName;
    private String password;
}
