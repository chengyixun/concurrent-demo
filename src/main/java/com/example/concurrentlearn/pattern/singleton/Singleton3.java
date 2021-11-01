package com.example.concurrentlearn.pattern.singleton;

/**
 * @Author: wangyu
 * @Date: Created 2020-12-08 10:18
 * @Description: 饿汉式
 * @Modified By:
 */
public class Singleton3 {

    private static Singleton3 singleton3 = new Singleton3();

    Singleton3() {

    }

    public static Singleton3 getInstance() {
        return singleton3;
    }
}
