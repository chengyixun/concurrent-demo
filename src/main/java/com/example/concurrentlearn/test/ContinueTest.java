package com.example.concurrentlearn.test;

/**
 * @Author: wangyu
 * @Date: Created 2020-07-21 23:12
 * @Description:
 * @Modified By:
 */
public class ContinueTest {

    public static void main(String[] args) {

       // doWhileTest();
        // add1(); // a:0
        // add2();// a:5
        // add3();
        str1();
    }

    public static void doWhileTest(){
        int i = 1, j = 10;
        do {
            if (i++ < --j)
                System.out.println(">>>after i：" + i + " ，j：" + j);
            continue;

        } while (i < 5);
        System.out.println(">>>>end i：" + i + " ，j：" + j); //i：5 j:6
    }

    public static void str1() {

        String s1 = new String("Test");
        String s2 = new String("Test");

        if (s1 == s2) {
            System.out.println("Same");
        }

        if (s1.equals(s2)) {
            System.out.println("equal");
        }
    }

    public static void add3() {
        Integer integer = 1;
        int val = integer.intValue();
        System.out.println(val);
        val += 3;
        System.out.println(val);

        integer = new Integer(val);
        System.out.println(integer);
    }


    public static void add1() {
        int a = 0;
        for (int i = 0; i < 5; i++) {
            a = a++;
        }
        System.out.println("a: " + a);
    }

    public static void add2() {
        int a = 0;
        for (int i = 0; i < 5; i++) {
            a = ++a;
        }
        System.out.println("a: " + a);
    }

    public static void byteM() {
        byte b = 127;
        byte c = 126;
        byte d = (byte) (b + c);
        System.out.println(d + " , ww:" + (b + c));
    }

}
