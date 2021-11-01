package com.example.concurrentlearn.test;

import java.util.HashMap;

/**
 * @Author: wangyu
 * @Date: Created 2020-07-11 11:33
 * @Description:
 * @Modified By:
 */
public class HelloGC {

    public static void main(String[] args) throws InterruptedException {
        byte[] byteArray = new byte[50 * 1024 * 1024];
        System.out.println("--------HelloGC");
        // Thread.sleep(Integer.MAX_VALUE);
       /*        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("processors: " + processors);

        //返回java虚拟机中的内存总量  默认是本机内存的64分之一
        long totalMemory = Runtime.getRuntime().totalMemory();
        //返回java虚拟机试图使用的最大内存量  默认是本机内存的4分之一
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("TOTAL_MEMORY(-Xms)= " + totalMemory + "（字节）、" + (totalMemory / 1024 / 1024) + " MB");

        System.out.println("TOTAL_MEMORY(-Xms)= " + maxMemory + "（字节）、" + (maxMemory / 1024 / 1024) + " MB");
*/
        HashMap hashMap = new HashMap();
        hashMap.put("1","2");
    }
}
