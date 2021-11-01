package com.example.concurrentlearn.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: wangyu
 * @Date: Created 2020-05-25 21:27
 * @Description: 演示ABA问题
 * @Modified By:
 */
public class ABATest {

    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

    public static void main(String[] args) {

        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);

        }, "T1").start();


        new Thread(() -> {
            try {
                //T2线程暂停1秒钟，保证上面T1线程完成一次ABA操作
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicReference.compareAndSet(100, 2019) + "\t" + atomicReference.get());

        }, "T2").start();

        System.out.println();

    }
}
