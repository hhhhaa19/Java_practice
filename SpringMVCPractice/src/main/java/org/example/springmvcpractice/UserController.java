package org.example.springmvcpractice;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-05-26
 * Time: 0:48
 */
@RequestMapping("/hello")
@RestController
public class UserController {
    @RequestMapping("/MVC")
    public String helloMVC() {
        return "Hello MVC";
    }

    @RequestMapping("/MVC2")
    public String helloMVC2(String name, Integer age) {
        return "hello:" + name + ",age:" + age;
    }

    @RequestMapping("/MVC3")
    public String helloMVC3(@RequestParam Person person) {
        return person.toString();
    }

    @RequestMapping("/MVC4")
    public String helloMVC4(@RequestParam String Name) {
        return Name;
    }

    @RequestMapping("/MVC5")
    public String helloMVC5(@RequestParam(value = "name", required = false) String userName) {
        return userName;
    }

    @RequestMapping("/MVC6")
    public String helloMVC6(@RequestParam List<String> list) {
        return list.toString();
    }

    @RequestMapping("/MVC7")
    public String helloMVC7(@RequestBody String name) {
        return name;
    }

    @RequestMapping("/MVC8")
    public String helloMVC8(@RequestBody Person person) {
        return person.toString();
    }

    @RequestMapping("/MVC9/{id}/{name}")
    public String helloMVC9(@PathVariable Integer id, @PathVariable("name") String userName) {
        return Integer.toString(id);
    }

    //Cookies由前端设置,在第二次request时产生这个cookies，其中会包含sessionId这里由于自己造的所以没有
    @RequestMapping("/Cookies")
    public String getCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Arrays.stream(cookies).filter(ck -> ck.getName().equals("benjamin")).forEach(ck -> {
                System.out.println(ck.getName() + ":" + ck.getValue());
            });
        }
        return "get cookies";
    }
    @RequestMapping("/Cookies2")
    public String getCookies2(@CookieValue(value = "benjamin",required = false) Integer score) {
        return score+"";
    }
//session 在后端设置，先有request，产生对应的sessionId
    @RequestMapping("/SetSession")
    public String setSection(HttpServletRequest request){
        HttpSession session = request.getSession();//1.若request的cookies中不存在对应的sessionId，怎产生一个 2.若存在，则根据对应的sessionId 找到 session
        session.setAttribute("username","benjamin");
        return "set section";
    }
    //设置了session就自动让客户端创建cookies
}
