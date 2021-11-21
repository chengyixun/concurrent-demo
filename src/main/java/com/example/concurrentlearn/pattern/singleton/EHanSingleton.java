package com.example.concurrentlearn.pattern.singleton;

/**
 * @Author: wangyu @Date: Created 2020-12-08 10:18 @Description: 饿汉式
 * 实例在初始化的时候就已经建好了，不管你后面有没有用到，都先新建好实例再说。这个就没有线程安全的问题，但是呢，浪费内存空间呀。 @Modified By:
 */
public class EHanSingleton {

  private static EHanSingleton singleton = new EHanSingleton();

  EHanSingleton() {}

  public static EHanSingleton getInstance() {
    return singleton;
  }
}
