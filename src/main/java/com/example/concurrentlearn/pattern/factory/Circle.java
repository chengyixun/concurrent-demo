package com.example.concurrentlearn.pattern.factory;

/**
 * @Author: wangyu
 * @Date: Created 2020-12-07 11:50
 * @Description:
 * @Modified By:
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
