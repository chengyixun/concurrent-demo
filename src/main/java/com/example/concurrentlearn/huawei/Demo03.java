package com.example.concurrentlearn.huawei;

import java.util.Scanner;

/**
 * @Author: wangyu
 * @Date: Created 2020-06-07 20:01
 * @Description:
 * @Modified By:
 */
public class Demo03 {

    public static void main(String[] args) {
        //method1();
        //method2();
        //  method3();
        method4();


    }


    private static void method5() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int calculate = calculate(s);
            System.out.println(calculate);
        }

    }

    /* 功能：四则运算

     * 输入：strExpression：字符串格式的算术表达式，如: "3+2*{1+2*[-4/(8-6)+7]}"

     * 返回：算术表达式的计算结果

     */

    public static int calculate(String strExpression) {

        /* 请实现*/
        if(strExpression.contains("{")){
            int i = strExpression.indexOf("{");
            int j = strExpression.indexOf("}");
            String substring = strExpression.substring(i, j);
            System.out.println(substring);
        }


        return 0;
    }

    /**
     * 有一只兔子，从出生后第3个月起每个月都生一只兔子，
     * 小兔子长到第三个月后每个月又生一只兔子，
     * 假如兔子都不死，问每个月的兔子总数为多少？
     * 统计兔子总数 ？
     * 输入月份：n
     * 求兔子总数
     */
    private static void method4() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int nextInt = sc.nextInt();
            getTotalCount(nextInt);
        }

    }

    public static int getTotalCount(int monthCount) {
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 2; i < monthCount; ++i) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }

    /**
     * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，
     * 她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，
     * 喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。
     * 然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
     * 如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
     */
    private static void method3() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();

            if (num == 0)
                break;
            int left = num;

            int total = 0;

            while (left != 0) {

                if (left == 2) {
                    total += 1;
                    break;
                } else if (left == 1) {
                    break;
                } else {
                    int curr = left / 3;
                    total += curr;
                    left = left - curr * 3 + curr;
                }
            }
            System.out.println(total);
        }
    }


    private static void method2() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int nextInt = scanner.nextInt();
            String s = String.valueOf(nextInt);
            System.out.println(new StringBuilder(s).reverse());
        }
    }

    private static void method1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int nextInt = scanner.nextInt();
            System.out.println(2 * nextInt + 3 * nextInt * (nextInt - 1) / 2);
        }
    }

}
