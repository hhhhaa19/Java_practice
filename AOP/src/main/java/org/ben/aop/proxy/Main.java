package org.ben.aop.proxy;


import org.ben.aop.model.landlord;

import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-25
 * Time: 11:56
 */
public class Main {
    /**
     * ClassLoader loader: 第一个参数是创建代理对象的类型
     * Class<?>[] interface : 可以代理哪些方法
     * InvocationHandler: 具体实现的 advice
     */
    //其实从本质上讲，我们不需要创建一个代理对象，我们需要的只是在两个方法中间动态的调用一个方法
    public static void main1(String[] args) {
        HouseDeal landlord = new landlord("ben");
        //创建代理，与静态代理一致，中间管理委托对象
        // 第一个参数是创建代理对象的类型
        // 第三个参数用于创建一个目标对象
        HouseDeal houseDeal = (HouseDeal) Proxy.newProxyInstance(
                HouseDeal.class.getClassLoader(),
                new Class[]{HouseDeal.class},
                new JDKInvocationHandler(landlord)
        );
        houseDeal.rent();
    }

    public static void main(String[] args) {
        HouseDeal landlord = new landlord("ben");
        landlord landlordProxy = (landlord) Enhancer.create(landlord.class,new CGLIBInterceptor(landlord));
        landlordProxy.seal();
    }
}
