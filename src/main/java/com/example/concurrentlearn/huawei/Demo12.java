package com.example.concurrentlearn.huawei;

import org.springframework.util.StringUtils;

import java.util.Scanner;

/**
 * @Author: wangyu
 * @Date: Created 2020-06-09 21:33
 * @Description:
 * @Modified By:
 */
public class Demo12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String next = scanner.next();
            String [] arr = next.split("");
            for (int i = 0; i <arr.length ; i++) {
                for(int j =i+1;j<arr.length;j++){
                    if(arr[i].equals(arr[j])){
                        System.out.println(arr[i]);
                        break;
                    }
                }
            }

        }
    }
}

