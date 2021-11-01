package com.example.concurrentlearn.pattern.proxy;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @Author: wangyu
 * @Date: Created 2020-12-07 11:15
 * @Description:
 * @Modified By:
 */
public class CglibTest {

    public static void main(String[] args) {
        System.out.println("************");
        CglibTest test = new CglibTest();
        TargetC proxyTarget = (TargetC) test.createProxy(TargetC.class);
        String result = proxyTarget.execute();
        System.out.println(result);

    }

    /**
     * 代理对象的生成过程由Enhancer类实现，步骤如下：
     * 1、生成代理类Class的二进制字节码
     * 2、通过Class.forName加载二进制字节码，生成Class对象；
     * 3、通过反射机制获取实例构造，并初始化代理类对象。
     * @param targetClass
     * @return
     */
    public Object createProxy(Class targetClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        enhancer.setCallback(new MyMethodInterceptor());
        return enhancer.create();
    }
}
