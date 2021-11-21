package com.example.concurrentlearn.pattern.singleton;

/**
 * @ClassName: InnerClassSingleton @Author: amy @Description: InnerClassSingleton @Date:
 * 2021/11/21 @Version: 1.0
 */
public class InnerClassSingleton {

  /**
   * 静态内部类的实现方式，效果有点类似双重校验锁。
   *
   * <p>但这种方式只适用于静态域场景，双重校验锁方式可在实例域需要延迟初始化时使用。
   */
  private static class InnerClassSingletonHolder {
    private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
  }

  private InnerClassSingleton() {}

  public static final InnerClassSingleton getInstance() {
    return InnerClassSingletonHolder.INSTANCE;
  }
}
