package com.example.concurrentlearn.test;

import java.lang.ref.SoftReference;

/**
 * @Author: wangyu
 * @Date: Created 2020-08-09 13:15
 * @Description:
 * @Modified By:
 */
public class RefDemo {

    public static void main(String[] args) {
       // softRef_Memory_Enough();
        softRef_Memory_NotEnough();
    }

    /**
     * 内存充足情况下，手动GC
     */
    public static void softRef_Memory_Enough() {
        Object o1 = new Object();
        SoftReference<Object> ref = new SoftReference<Object>(o1);
        System.out.println(o1);
        System.out.println(ref.get());

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(ref.get());
    }

    /**
     * JVM配置，故意产生大对象并配置小的内存，让他内存不够用导致GC，看软引用的回收情况
     * -Xms5m -Xmx5m -XX:+PrintGCDetails
     *
     *此时内存不足，软引用被回收 为null
     */
    public static void softRef_Memory_NotEnough() {
        Object o1 = new Object();
        SoftReference<Object> ref = new SoftReference<Object>(o1);
        System.out.println(o1);
        System.out.println(ref.get());

        o1 = null;
        try {
            byte[] b = new byte[10 * 1024 * 1024];

        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(o1);
            System.out.println(ref.get());
        }


    }

}
