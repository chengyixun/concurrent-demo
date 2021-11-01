package com.example.concurrentlearn.huawei;

import java.util.Scanner;

/**
 * @Author: wangyu
 * @Date: Created 2020-06-09 21:16
 * @Description:
 * @Modified By:
 */
public class Demo11 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            //4+3*6  4*3+6
            if (next.contains("+")) {
                int i = next.indexOf("+");
                String pre = next.substring(0, i);
                String sub = next.substring(i+1);
                System.out.println(Integer.valueOf(pre)+Integer.valueOf(sub));
            }else if(next.contains("-")){
                int i = next.indexOf("-");
                String pre = next.substring(0, i);
                String sub = next.substring(i+1);
                System.out.println(Integer.valueOf(pre)-Integer.valueOf(sub));
            }else if(next.contains("*")){

                int i = next.indexOf("*");
                String pre = next.substring(0, i);
                String sub = next.substring(i+1);
                System.out.println(Integer.valueOf(pre)*Integer.valueOf(sub));
            }
        }
    }
}
