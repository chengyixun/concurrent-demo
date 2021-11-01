package com.example.concurrentlearn.test;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangyu
 * @Date: Created 2020-09-29 22:59
 * @Description:
 * @Modified By:
 */
@Data
public class MyClass {

    /**
     * final修饰成员变量
     */
    private final double i = Math.random();

    /**
     * static修饰成员变量  用来只保存一个副本
     */
    private static double j = Math.random();


    public static void main(String[] args) {

        MyClass m1 = new MyClass();
        MyClass m2 = new MyClass();

        System.out.println(m1.i);
        System.out.println(m2.i);
        System.out.println(m1.j);
        System.out.println(m2.j);

        int num[] ={1,2,3,4};

        //List<Integer> list = new ArrayList<Integer>(num);

    }

}
