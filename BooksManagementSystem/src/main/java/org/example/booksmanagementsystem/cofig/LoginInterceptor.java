package org.example.booksmanagementsystem.cofig;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.booksmanagementsystem.Enum.LoginStatus;
import org.example.booksmanagementsystem.component.Session;
import org.example.booksmanagementsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-23
 * Time: 20:01
 */
@Slf4j
@Configuration
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    Session session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute(session.getUserInfo());
        log.info("访问用户:{}", user);
        if (user == null) {
            //response.sendRedirect("/login");//试一下，返回的是200还是400
            response.setStatus(401);//这里我们认为是一种失败
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
