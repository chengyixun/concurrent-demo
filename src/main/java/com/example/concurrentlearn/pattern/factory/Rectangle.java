package com.example.concurrentlearn.pattern.factory;

/**
 * @Author: wangyu
 * @Date: Created 2020-12-07 11:49
 * @Description:
 * @Modified By:
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
