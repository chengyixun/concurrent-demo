package com.example.concurrentlearn.huawei;

import org.springframework.util.StringUtils;

import java.util.Scanner;

/**
 * @Author: wangyu
 * @Date: Created 2020-06-07 19:29
 * @Description:
 * @Modified By:
 */
public class Demo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            System.out.println(new StringBuilder(next).reverse().toString());

        }
    }
}
