package com.example.concurrentlearn.pattern.singleton;

/**
 * @Author: wangyu
 * @Date: Created 2020-12-08 10:16
 * @Description: 懒汉式 ，线程安全
 * @Modified By:
 */
public class Singleton2 {

    private static Singleton2 singleton2;

    private Singleton2() {
    }

    public static synchronized Singleton2 getInstance() {
        if (null == singleton2) {
            singleton2 = new Singleton2();
        }

        return singleton2;
    }
}
