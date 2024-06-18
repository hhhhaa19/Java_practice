package org.example.booksmanagementsystem.Controller;

import org.example.booksmanagementsystem.model.User;
import org.example.booksmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public Boolean login(User user) {
        return userService.login(user);
    }

    @RequestMapping("/admin")
    public String admin() {
        return userService.getUserDao().getAdmin().toString();
    }
    @Value("${string.str1}")
    private String str1;
    @Value("${string.str2}")
    private String str2;
    @Value("${string.str3}")
    private String str3;
    @RequestMapping("/printString")
    public void printString() {
        //System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }

}
