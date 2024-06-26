package org.example.booksmanagementsystem.cofig;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-25
 * Time: 0:04
 */
@Slf4j
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* org.example.booksmanagementsystem.Controller.*.* (..))")
    public Object recordTime(ProceedingJoinPoint processingJoinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();
        Object result = processingJoinPoint.proceed();
        log.info(processingJoinPoint.getSignature() + "耗时 {} ms", System.currentTimeMillis() - startTime);
        return result;
    }

}
