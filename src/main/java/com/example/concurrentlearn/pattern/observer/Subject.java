package com.example.concurrentlearn.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/** @Author: wangyu @Date: Created 2020-12-08 10:42 @Description: @Modified By: */
public class Subject {

  private List<Observer> observers = new ArrayList<>();

  private int state;

  public int getState() {
    return state;
  }

  /**
   * 当状态被变更时，自定通知所有依赖它的对象并自动更新
   *
   * @param state
   */
  public void setState(int state) {
    this.state = state;
    notifyAllObservers();
  }

  public void notifyAllObservers() {
    System.out.println(">> notifyAllObservers current observer size:" + observers.size());
    observers.stream().forEach(t -> t.update());
  }

  public void attach(Observer observer) {
    observers.add(observer);
    System.out.println(">>attach current observer size:" + observers.size());
  }
}
