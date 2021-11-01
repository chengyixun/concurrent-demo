package com.example.concurrentlearn.pattern.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: wangyu
 * @Date: Created 2020-12-07 10:03
 * @Description:
 * @Modified By:
 */
@Slf4j
public class DynamicProxyHandler implements InvocationHandler {

    private Target target;

    public DynamicProxyHandler(Target target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("======before======");
        Object invoke = method.invoke(target, args);
        log.info("======after======");
        return invoke;
    }
}
