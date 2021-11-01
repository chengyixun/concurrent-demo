package com.example.concurrentlearn.test;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @Author: wangyu
 * @Date: Created 2020-08-27 16:41
 * @Description:
 * @Modified By:
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal<>();
        Random random = new Random();
        IntStream.range(0, 5).forEach(f -> new Thread(() -> {

            //为每个线程设置相应的local值
            local.set(f + " " + random.nextInt(10));
            System.out.println("当前线程 和 值：" + local.get());

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start());

    }
}
