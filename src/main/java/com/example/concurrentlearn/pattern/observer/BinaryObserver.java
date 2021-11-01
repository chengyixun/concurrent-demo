package com.example.concurrentlearn.pattern.observer;

/**
 * @Author: wangyu
 * @Date: Created 2020-12-08 10:49
 * @Description: 创建实体观察者类
 * @Modified By:
 */
public class BinaryObserver extends Observer {

    BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("current state:" + subject.getState() + " Binary String:" + Integer.toBinaryString(subject.getState()));

    }
}
