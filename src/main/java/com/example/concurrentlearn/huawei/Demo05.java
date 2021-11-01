package com.example.concurrentlearn.huawei;

import java.util.Scanner;

/**
 * @Author: wangyu
 * @Date: Created 2020-06-08 23:10
 * @Description: 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 * <p>
 * 例如：
 * <p>
 * 1^3=1
 * <p>
 * 2^3=3+5
 * <p>
 * 3^3=7+9+11
 * <p>
 * 4^3=13+15+17+19
 * @Modified By:
 */
public class Demo05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int i = scanner.nextInt();
            System.out.println(getSequeOddNum(i));
        }
    }


    /**
     * @param m
     * @return m个连续奇数(格式 ： “ 7 + 9 + 11 ”);
     */
    public static String getSequeOddNum(int m) {
        int[] nums = new int[m];
        //推理得 连续奇数相加的 第一项为：m*m -(m-1)
        nums[0] = m * m - m + 1;

        if (m == 1) {
            return String.valueOf(nums[0]);
        } else {

            for (int i = 1; i < m; i++) {
                nums[i] = nums[i - 1] + 2;
            }
        }

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(nums[0]);
        for (int i = 1; i < m; i++) {
            stringBuffer.append("+");
            stringBuffer.append(nums[i]);
        }

        return stringBuffer.toString();
    }
}
