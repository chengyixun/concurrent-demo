package com.example.concurrentlearn.test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wangyu
 * @Date: Created 2021-02-03 22:42
 * @Description: 搞清楚线程池的执行顺序
 * @Modified By:
 */
public class MyThreadPoolDemo2 {

    //线程池的执行顺序是：核心线程数 -> 等待队列 -> 最大线程数 -> 拒绝策略
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                2,
                6,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 15; i++) {
            final int id = i;
            poolExecutor.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName()+":"+id);
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });


        }

        /**
         * 第一步，任务0、1提交时，创建核心线程并执行
         * 第二步，任务2、3、4、5、6提交时，将其放在缓存队列
         * 第三步，任务7、8、9、10提交时，创建线程并执行，直到池子满了（线程池满了时，线程数为6）
         * 第四步，任务11、12、13、14、15被拒绝策略拒绝
         * 第五步，执行缓存队列中的任务2、3、4、5、6
         */


    }
}
