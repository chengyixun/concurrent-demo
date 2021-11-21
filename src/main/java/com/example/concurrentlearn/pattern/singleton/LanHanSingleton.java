package com.example.concurrentlearn.pattern.singleton;

/**
 * @Author: wangyu @Date: Created 2020-12-08 10:16 @Description: 懒汉式 ，线程安全 实例在需要用到的时候，才去创建
 * 如果有则返回，没有则新建 @Modified By:
 */
public class LanHanSingleton {

  private static LanHanSingleton lanHanSingleton;

  private LanHanSingleton() {}

  public static synchronized LanHanSingleton getInstance() {
    if (null == lanHanSingleton) {
      lanHanSingleton = new LanHanSingleton();
    }
    return lanHanSingleton;
  }
}
