package com.example.concurrentlearn.pattern.decorator;

/**
 * @Author: wangyu
 * @Date: Created 2020-12-08 11:38
 * @Description:
 * @Modified By:
 */
public abstract class ShapeDecorator implements Shape {

    protected Shape decoratorShape;

    ShapeDecorator(Shape decoratorShape) {
        this.decoratorShape = decoratorShape;
    }

    @Override
    public void draw() {
        decoratorShape.draw();
    }
}
