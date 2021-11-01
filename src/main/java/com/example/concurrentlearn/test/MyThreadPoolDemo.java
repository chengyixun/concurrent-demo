package com.example.concurrentlearn.test;

import java.util.concurrent.*;

/**
 * @Author: wangyu
 * @Date: Created 2020-06-27 18:33
 * @Description:
 * @Modified By:
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {
        // executorJDK();

        //core:2 max:5 keepAlive blockQueue:3 defaultFactory 拒绝策略
        /**拒绝策略 当前线程数 > (max+blockQueue)
         * new ThreadPoolExecutor.AbortPolicy()  直接抛错 RejectedExecutionException
         * new ThreadPoolExecutor.CallerRunsPolicy()
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        try {

            for (int i = 1; i <= 10; i++) {
                threadPoolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            threadPoolExecutor.shutdown();
        }


    }

    private static void executorJDK() {
        //   System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService service = Executors.newFixedThreadPool(5); //一池5个线程
        // ExecutorService executorService = Executors.newSingleThreadExecutor();//一池1线程
        // ExecutorService executorService = Executors.newCachedThreadPool();//一池N线程
        try {
            //模拟10个人去银行窗口办理业务
            for (int i = 1; i <= 10; i++) {
                service.execute(() -> {
                    //do something
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();

        }
    }
}
