package com.example.concurrentlearn.test;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wangyu
 * @Date: Created 2020-05-30 11:10
 * @Description:
 * @Modified By:
 * <p>
 * 1. 队列  FIFO  先进先出
 * 2. 阻塞队列
 */
public class BlockingQueneDemo {
    public static void main(String[] args) {

        executeSynchronousQueue();
    }

    /**
     * SynchronousQueue 没有容量
     * 与其他阻塞队列不同，SynchronousQueue是一个不存储元素的Queue
     * 每一个put操作必须等待take操作，否则不能继续添加元素
     * <p>
     * demo 案例演示
     */
    private static void executeSynchronousQueue() {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t put 1");
                blockingQueue.put("1");

                System.out.println(Thread.currentThread().getName() + "\t put 2");
                blockingQueue.put("2");

                System.out.println(Thread.currentThread().getName() + "\t put 3");
                blockingQueue.put("3");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A线程").start();

        new Thread(() -> {

            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "\t " + blockingQueue.take());

                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "\t " + blockingQueue.take());

                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "\t " + blockingQueue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "B线程").start();
    }
}
