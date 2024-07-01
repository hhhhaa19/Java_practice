package org.ben.aop.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-26
 * Time: 1:20
 */
public class CGLIBInterceptor implements MethodInterceptor {
    Object target;

    public CGLIBInterceptor(Object target) {
        this.target = target;
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("开始代理");
        Object o = proxy.invoke(target, args);
        System.out.println("代理结束");
        return o;
    }
}
