package com.example.concurrentlearn.pattern.proxy;

/**
 * @Author: wangyu
 * @Date: Created 2020-12-07 10:52
 * @Description: 目标类
 * 无论是动态代理还是静态代理，都需要定义接口，然后才能实现代理功能。这同样存在局限性，
 * 因此，为了解决这个问题，出现了第三种代理方式：cglib代理。
 * @Modified By:
 */
public class TargetC {

    public String execute() {
        String message = "-----test-----";
        System.out.println(message);
        return message;
    }
}
