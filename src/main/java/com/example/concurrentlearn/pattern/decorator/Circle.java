package com.example.concurrentlearn.pattern.decorator;

/**
 * @Author: wangyu
 * @Date: Created 2020-12-08 11:34
 * @Description:
 * @Modified By:
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle ");
    }
}
