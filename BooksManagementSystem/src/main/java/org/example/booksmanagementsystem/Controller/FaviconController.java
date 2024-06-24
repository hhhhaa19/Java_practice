package org.example.booksmanagementsystem.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-25
 * Time: 0:42
 */
@RestController
public class FaviconController {
    @RequestMapping ("favicon.ico")
    void returnNoFavicon() {
        // 不返回任何内容
    }
}
