package com.example.concurrentlearn.huawei;

import java.util.Scanner;

/** @Author: wangyu @Date: Created 2020-06-13 11:31 @Description: @Modified By: */
public class Demo13 {

  public static void main(String[] args) {
    /* int sum = 0;
    for (int i = 1; i < 21; i++) {
      if (i % 2 == 0) {
        sum = sum - i;
      } else {
        sum = sum + i;
      }
    }
    System.out.println(sum);*/

    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      int i = sc.nextInt();

      System.out.println(getMethod(i));
    }
  }

  private static String getMethod(int time) {
    // 声明三个变量
    int hour = 0, min = 0, sec = 0;
    // 计算出小时
    hour =  time / (60 * 60);
    // 计算出分钟
    min = (time - hour * 3600) / 60;
    // 计算出秒数
    sec =  time - hour * 3600 - min * 60;

    return new StringBuffer()
        .append(hour)
        .append("时")
        .append(min)
        .append("分钟")
        .append(sec)
        .append("秒")
        .toString();
  }
}
