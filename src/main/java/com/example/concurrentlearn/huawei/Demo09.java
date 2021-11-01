package com.example.concurrentlearn.huawei;

import java.util.Scanner;

/**
 * @Author: wangyu
 * @Date: Created 2020-06-09 20:44
 * @Description:
 * @Modified By:
 */
public class Demo09 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(m * n / getResult(m, n));
        }


    }

    public static int getResult(int m, int n) {
        if (m < n) {
            int temp = m;
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
