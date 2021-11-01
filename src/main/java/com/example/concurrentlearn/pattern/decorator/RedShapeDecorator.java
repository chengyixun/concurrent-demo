package com.example.concurrentlearn.pattern.decorator;

/**
 * @Author: wangyu
 * @Date: Created 2020-12-08 11:54
 * @Description:
 * @Modified By:
 */
public class RedShapeDecorator extends ShapeDecorator {

    RedShapeDecorator(Shape decoratorShape) {
        super(decoratorShape);
    }

    @Override
    public void draw() {
        super.draw();
        //do something
        System.out.println("Border Color: Red");
    }
}
