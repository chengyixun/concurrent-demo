package com.example.concurrentlearn.pattern.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;

/**
 * @Author: wangyu
 * @Date: Created 2020-12-07 10:14
 * @Description: JDK动态代理
 * * 无论是动态代理还是静态代理，都需要定义接口，然后才能实现代理功能。
 * @Modified By:
 */
@Slf4j
public class DynamicProxyTest {

    public static void main(String[] args) {
        Target target = new TargetImpl();
        DynamicProxyHandler handler = new DynamicProxyHandler(target);
        Target proxySubject = (Target) Proxy.newProxyInstance(TargetImpl.class.getClassLoader(), TargetImpl.class.getInterfaces(), handler);
        String result = proxySubject.execute();
        log.info(result);
    }
}
