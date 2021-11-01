package com.example.concurrentlearn.pattern.factory;

/**
 * @Author: wangyu
 * @Date: Created 2020-12-07 11:54
 * @Description: 意图：定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。
 * 主要解决：主要解决接口选择的问题。
 * @Modified By:
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        //获取 Circle 的对象，并调用它的 draw 方法
        Shape circle = shapeFactory.getShape("CIRCLE");
        circle.draw();

        //获取 Rectangle 的对象，并调用它的 draw 方法
        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        rectangle.draw();

        //……
    }
}
