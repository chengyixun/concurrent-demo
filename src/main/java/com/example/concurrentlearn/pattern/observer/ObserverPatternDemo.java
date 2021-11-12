package com.example.concurrentlearn.pattern.observer;

/**
 * @Author: wangyu @Date: Created 2020-12-08 11:14 @Description:
 *
 * <p>当对象间存在一对多关系时，则使用观察者模式（Observer Pattern）。比如，当一个对象被修改时，则会自动通知它的依赖对象。观察者模式属于行为型模式。
 * 意图：定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
 * 主要解决：一个对象状态改变给其他对象通知的问题，而且要考虑到易用和低耦合，保证高度的协作。 @Modified By:
 */
public class ObserverPatternDemo {
  public static void main(String[] args) {
    Subject subject = new Subject();
    new BinaryObserver(subject);
    new OctalObserver(subject);
    new HexaObserver(subject);

    System.out.println("First state change:15");
    subject.setState(15);
    System.out.println();

    System.out.println("Second state change:10");
    subject.setState(10);
  }
}
