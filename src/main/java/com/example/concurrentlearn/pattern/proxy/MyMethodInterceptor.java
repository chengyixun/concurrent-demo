package com.example.concurrentlearn.pattern.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: wangyu
 * @Date: Created 2020-12-07 11:01
 * @Description:
 * @Modified By:
 */
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(">>>MyMethodInterceptor start……");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println(">>>MyMethodInterceptor end……");
        return result;
    }
}
