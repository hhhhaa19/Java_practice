package org.ben.aop.demo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-25
 * Time: 1:25
 */
@Order(1)
@Aspect
@Component
@Slf4j
public class AspectDemo2 {

    @Around("@annotation(org.ben.aop.proxy.MyAnnotation)")
    public Object around2(ProceedingJoinPoint pjp) throws Throwable {
        log.info("around2 start");
        Object o = pjp.proceed();
        log.info("around2 end");
        return o;
    }
}
