package org.example.springmvcpractice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-05-28
 * Time: 15:53
 */
@Controller
@RequestMapping("calc")
public class CalculatorController {
    @ResponseBody
    @RequestMapping(value = "/sum")
    public String sum(Integer num1, Integer num2) {
        return "<h1>" + num1 + " + " + num2 + " is " +(num1+num2)+" </h1>";
    }
}
