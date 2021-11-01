package com.example.concurrentlearn.pattern.decorator;

/**
 * @Author: wangyu
 * @Date: Created 2020-12-08 11:57
 * @Description:
 * 装饰器模式（Decorator Pattern）允许向一个现有的对象添加新的功能，同时又不改变其结构。这种类型的设计模式属于结构型模式，它是作为现有的类的一个包装。
 * 意图：动态地给一个对象添加一些额外的职责。就增加功能来说，装饰器模式相比生成子类更为灵活。
 * 主要解决：一般的，我们为了扩展一个类经常使用继承方式实现，由于继承为类引入静态特征，并且随着扩展功能的增多，子类会很膨胀。
 * @Modified By:
 */
public class DecoratorPatternDemo {

    public static void main(String[] args) {

        Shape circle = new Circle();

        Shape redCricle = new RedShapeDecorator(new Circle());

        Shape redRectangel = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCricle.draw();


        System.out.println("\nRectangle of red border");
        redRectangel.draw();
    }
}
