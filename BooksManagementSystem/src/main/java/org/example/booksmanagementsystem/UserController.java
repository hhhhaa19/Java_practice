package org.example.booksmanagementsystem;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-12
 * Time: 10:03
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public Boolean login(User user) {
        if(!StringUtils.hasLength(user.getUserName())||!StringUtils.hasLength(user.getPassword())) {
            return false;
        }
        if("benjamin".equals(user.getUserName()) && "123456".equals(user.getPassword())) {
            return true;
        }
        return false;
    }
}
