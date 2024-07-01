package org.ben.aop.proxy;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-25
 * Time: 11:48
 */
public class JDKInvocationHandler implements InvocationHandler {
    private Object target;//被代理对象，实际调用的是他的方法

    public JDKInvocationHandler(Object target) {
        this.target = target;
    }
//代理对象 通过invoke 调用目标对象的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //advice
        System.out.println("开始代理");
        Object o = method.invoke(target, args);//调用被代理对象的方法
        System.out.println("结束代理");
        return o;
    }
}
