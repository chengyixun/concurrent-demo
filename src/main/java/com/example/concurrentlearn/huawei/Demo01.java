package com.example.concurrentlearn.huawei;

import java.util.Scanner;

/**
 * @Author: wangyu
 * @Date: Created 2020-06-07 18:54
 * @Description: 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，
 * 设计一个算法，求输入A和B的最小公倍数。
 * eg: m =3 ,n = 5 最小公倍数：15
 * m =4, n = 6 最小公倍数：12
 * @Modified By:
 */
public class Demo01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(m * n / getResult(m, n));

        }
    }


    public static int getResult(int m, int n) {
        //满足m<n 交换位置
        int temp;
        if (m < n) {
            temp = m;
            m = n;
            n = temp;
        }

        int k;
        while (n != 0) {
            k = m % n;
            m = n;
            n = k;
        }
        return m;

    }
}
