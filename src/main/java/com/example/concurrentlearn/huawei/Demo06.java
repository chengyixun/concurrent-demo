package com.example.concurrentlearn.huawei;

import java.util.Scanner;

/**
 * @Author: wangyu
 * @Date: Created 2020-06-08 23:34
 * @Description:
 * @Modified By:
 */
public class Demo06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int count = 0;
            for (int i = 2; i <= num; i++) {
                if (isPerfect(i)) {
                    count++;
                }

            }

            System.out.println(count);

        }

    }

    private static boolean isPerfect(int num) {
        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += 1;
                sum += num / i;
            }


        }
        return sum == num;

    }


}
