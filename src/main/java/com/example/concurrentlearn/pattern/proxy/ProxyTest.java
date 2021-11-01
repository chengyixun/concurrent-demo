package com.example.concurrentlearn.pattern.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: wangyu
 * @Date: Created 2020-12-07 09:53
 * @Description: 静态代理
 * 无论是动态代理还是静态代理，都需要定义接口，然后才能实现代理功能。
 * @Modified By:
 */
@Slf4j
public class ProxyTest {

    public static void main(String[] args) {
        Target target = new TargetImpl();
        Proxy p = new Proxy(target);
        String result = p.execute();
        log.info(result);
    }
}
