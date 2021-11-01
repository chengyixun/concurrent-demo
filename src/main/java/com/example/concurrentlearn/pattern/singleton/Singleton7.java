package com.example.concurrentlearn.pattern.singleton;

/**
 * @Author: wangyu
 * @Date: Created 2020-12-08 10:20
 * @Description: 双检锁/双重校验锁 + volatile关键字
 * @Modified By:
 */
public class Singleton7 {

    private static volatile Singleton7 instance = null;

    Singleton7() {
    }

    public static Singleton7 getInstance() {
        if (null == instance) {
            synchronized (Singleton7.class) {
                if (null == instance) {
                    instance = new Singleton7();
                }
            }
        }
        return instance;
    }

}
