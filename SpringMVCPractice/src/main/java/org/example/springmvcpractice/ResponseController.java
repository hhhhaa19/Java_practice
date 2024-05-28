package org.example.springmvcpractice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-05-28
 * Time: 14:29
 */
@RequestMapping("/res")
@Controller
public class ResponseController {
    @ResponseBody
    @RequestMapping("/getFile")
    public String getFile(@RequestPart("file") MultipartFile file) throws IOException {
        file.transferTo(new File("D:/temp/" + file.getOriginalFilename()));
        return file.getOriginalFilename();
    }

    @ResponseBody
    @RequestMapping("/session0")
    public String session(HttpServletRequest request) {
        request.getSession().setAttribute("username", "admin");
        return "success";
    }

    @ResponseBody
    @RequestMapping("/session1")
    public String session(HttpSession session) {
        session.setAttribute("username1", "admin1");
        return "success";
    }

    @ResponseBody
    @RequestMapping("/session2")
    public String session(@SessionAttribute(value = "username1", required = false) String username) {
        return username;
        //这种方式无法创建session，只读，一定要得到完整的session
    }

    @ResponseBody
    @RequestMapping("/header")
    public String header(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        return userAgent;
    }

    @RequestMapping("/Num")
    public String Num() {
        return "/numberGuess.html";
    }

    @ResponseBody
    @RequestMapping("/html")
    public String Html() {
        return "<html><body><h1>Hello World</h1></body></html>";
    }

    @ResponseBody
    @RequestMapping("/data")
    public HashMap<String, String> Data() {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", "admin");
        map.put("username1", "admin1");
        map.put("username2", "admin2");
        map.put("username3", "admin3");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/setRes", produces = "text/html")
    public String setRes(HttpServletResponse response) {
        return "{\"success\":true}";
    }
}
