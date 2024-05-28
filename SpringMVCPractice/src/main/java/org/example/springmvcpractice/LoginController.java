package org.example.springmvcpractice;

import jakarta.servlet.http.HttpSession;
import org.apache.coyote.http11.filters.SavedRequestInputFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-05-28
 * Time: 16:39
 */
@Controller
@RequestMapping("/user")
public class LoginController {
    @ResponseBody
    @RequestMapping("/login")
    public Boolean login(String userName, String password, HttpSession session) {
        if(userName == null || password == null){
            return false;
        }
        if("admin".equals(userName) && "123456".equals(password)){
            session.setAttribute("userName", userName);
            return true;
        }
        return false;
    }
    @ResponseBody
    @RequestMapping("/index")
    public String index(@SessionAttribute(value = "userName",required = false)String userName){
        return userName;
    }
}
