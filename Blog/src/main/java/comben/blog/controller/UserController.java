package comben.blog.controller;

import comben.blog.model.Result;
import comben.blog.model.UserInfo;
import comben.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-07-01
 * Time: 2:20
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public Result<String> login(UserInfo userInfo) {
        return userService.login(userInfo);
    }
}
