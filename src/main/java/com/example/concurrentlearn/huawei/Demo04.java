package com.example.concurrentlearn.huawei;

import java.util.Scanner;

/**
 * @Author: wangyu
 * @Date: Created 2020-06-07 21:33
 * @Description: * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
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
public class Demo04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int i = sc.nextInt();
            System.out.println(GetSequeOddNum(i));

        }

    }



     /*
      功能: 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
      原型：
      int GetSequeOddNum(int m,char * pcSequeOddNum);
      输入参数：
      int m：整数(取值范围：1～100)

     返回值：
          m个连续奇数(格式：“7+9+11”);
 */

    public static String GetSequeOddNum(int m) {
        /*在这里实现功能*/

        if (m == 1) {
            return "1";
        }
        //奇数
        if (m % 2 != 0) {
            double pow = Math.pow(m, 2);

            //次数
            StringBuilder sb = new StringBuilder();
            int temp = (m - 1) / 2;
            sb.append(pow+"+");
            for (int i = temp; i >0; i--) {
                sb.append(pow - 2 * i );
                sb.append("+" );
                sb.append(pow + 2 * i);
            }
            return sb.toString();

        }

        return null;
    }
}
