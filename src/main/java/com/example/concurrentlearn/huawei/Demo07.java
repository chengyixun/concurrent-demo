package com.example.concurrentlearn.huawei;

import java.util.Scanner;

/**
 * @Author: wangyu
 * @Date: Created 2020-06-09 20:30
 * @Description:
 * @Modified By:
 */
public class Demo07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int count = 0;
            while (n != 0) {
                count++;
                n = n & (n - 1);
            }
            System.out.println(count);

        }
    }
}
