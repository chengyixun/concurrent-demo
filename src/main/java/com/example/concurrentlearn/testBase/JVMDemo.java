package com.example.concurrentlearn.testBase;

/**
 * @Author: wangyu
 * @Date: Created 2020-11-26 19:37
 * @Description:
 * @Modified By:
 */
public class JVMDemo {

    public static void main(String[] args) {
        int sum = add(1, 2);
        print(sum);
    }

    public static int add(int a, int b) {
        a = 3;
        int result = a + b;
        return result;
    }
    public static void print(int num){
        System.out.println(num);
    }
}
