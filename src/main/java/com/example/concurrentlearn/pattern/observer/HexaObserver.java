package com.example.concurrentlearn.pattern.observer;

/**
 * @Author: wangyu
 * @Date: Created 2020-12-08 11:12
 * @Description:
 * @Modified By:
 */
public class HexaObserver extends Observer {

    HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("current state:" + subject.getState() +" Hexa String:" + Integer.toHexString(subject.getState()));

    }
}
