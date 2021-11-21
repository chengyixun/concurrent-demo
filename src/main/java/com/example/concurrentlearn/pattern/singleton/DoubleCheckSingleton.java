package com.example.concurrentlearn.pattern.singleton;

/**
 * @Author: wangyu @Date: Created 2020-12-08 10:20 @Description: 双检锁/双重校验锁 + volatile关键字 @Modified
 * By:
 */
public class DoubleCheckSingleton {

  private static volatile DoubleCheckSingleton instance = null;

  DoubleCheckSingleton() {}

  /**
   * 在synchronized关键字内外都加了一层 if 条件判断，
   *
   * <p>这样既保证了线程安全，又比直接上锁提高了执行效率，还节省了内存空间。
   *
   * @return
   */
  public static DoubleCheckSingleton getInstance() {
    if (null == instance) {
      synchronized (DoubleCheckSingleton.class) {
        if (null == instance) {
          instance = new DoubleCheckSingleton();
        }
      }
    }
    return instance;
  }
}
