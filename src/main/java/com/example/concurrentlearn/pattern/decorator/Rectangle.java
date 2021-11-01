package com.example.concurrentlearn.pattern.decorator;

/**
 * @Author: wangyu
 * @Date: Created 2020-12-08 11:33
 * @Description:
 * @Modified By:
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
