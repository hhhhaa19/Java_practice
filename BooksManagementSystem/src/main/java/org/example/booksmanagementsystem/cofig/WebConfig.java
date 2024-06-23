package org.example.booksmanagementsystem.cofig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-23
 * Time: 20:17
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry 里面存了一个registration lists,加入一个interceptor后返回一个配置registration
        //这个registration里面可以继续加配置,并返回自己
        //这里的路径都是网络路径
        registry.addInterceptor(loginInterceptor)
                        .addPathPatterns("/**")
                .excludePathPatterns("/user/**")
                .excludePathPatterns("/**/*.js")
                .excludePathPatterns("/**/*.css")
                .excludePathPatterns("/**/*.png")
                .excludePathPatterns("/**/*.jpg")
                .excludePathPatterns("/**/*.html");
    }
}
