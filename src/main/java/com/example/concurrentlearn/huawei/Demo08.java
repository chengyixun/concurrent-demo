package com.example.concurrentlearn.huawei;

import java.util.Scanner;

/**
 * @Author: wangyu
 * @Date: Created 2020-06-09 20:34
 * @Description:
 * @Modified By:
 */
public class Demo08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double v = scanner.nextDouble();
            int i = (int)v;
          //  v-i >=0.5?
            System.out.println(v-i>=0.5?i+1:i);

        }
    }
}
