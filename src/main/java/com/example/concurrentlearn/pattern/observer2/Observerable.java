package com.example.concurrentlearn.pattern.observer2;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @ClassName: Observerable
 * @Author: amy
 * @Description: Observerable 被观察者
 * @Date: 2021/11/11
 * @Version: 1.0
 */
public class Observerable {

    List<Observer> observers = Lists.newArrayList();


}
