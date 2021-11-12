package com.example.concurrentlearn.pattern.observer;

/** @Author: wangyu @Date: Created 2020-12-08 10:42 @Description: @Modified By: */
public abstract class Observer {

  protected Subject subject;

  public abstract void update();
}
