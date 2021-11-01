package com.example.concurrentlearn.pattern.factory;

import org.springframework.util.StringUtils;

/**
 * @Author: wangyu
 * @Date: Created 2020-12-07 11:51
 * @Description: 创建一个工厂，生成基于给定信息的实体类的对象。
 * @Modified By:
 */
public class ShapeFactory {

    /**
     * 使用 getShape 方法获取形状类型的对象
     *
     * @param shapeType
     * @return
     */
    public Shape getShape(String shapeType) {
        if (StringUtils.isEmpty(shapeType)) {
            return null;
        }
        shapeType = shapeType.toLowerCase();

        switch (shapeType) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            case "square":
                return new Square();
            default:
                return null;
        }

    }
}
