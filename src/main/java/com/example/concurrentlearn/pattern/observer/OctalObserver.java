package com.example.concurrentlearn.pattern.observer;

/** @Author: wangyu @Date: Created 2020-12-08 11:10 @Description: @Modified By: */
public class OctalObserver extends Observer {

  OctalObserver(Subject subject) {
    this.subject = subject;
    this.subject.attach(this);
  }

  @Override
  public void update() {
    System.out.println(
        "current state:"
            + subject.getState()
            + " Octal String:"
            + Integer.toOctalString(subject.getState()));
  }
}
