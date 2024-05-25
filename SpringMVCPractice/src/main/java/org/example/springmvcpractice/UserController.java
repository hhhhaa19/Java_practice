package org.example.springmvcpractice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public String helloMVC2(String name,Integer age) {
        return "hello:"+name+",age:"+age;
    }
    @RequestMapping("/MVC3")
    public String helloMVC3(Person person) {
        return person.toString();
    }
    @RequestMapping("/MVC4")
    public String helloMVC4( @RequestParam("name") String userName) {
        return userName;
    }
    @RequestMapping("/MVC5")
    public String helloMVC5( @RequestParam(value = "name",required = false) String userName) {
        return userName;
    }
}
