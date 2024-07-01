package org.ben.aop.demo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-25
 * Time: 1:08
 */
@Slf4j
@Aspect
@Component
@Order(99)
public class AspectDemo {
    @Pointcut("execution(* org.ben.aop.controller.*.* (..))")
    public void pointcut() {
    }


    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("around start");
        Object o = pjp.proceed();
        log.info("around end");
        return o;
    }


}
