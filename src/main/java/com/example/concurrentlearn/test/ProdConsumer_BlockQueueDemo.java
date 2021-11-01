package com.example.concurrentlearn.test;

import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: wangyu
 * @Date: Created 2020-05-31 15:18
 * @Description:
 * @Modified By:
 */
public class ProdConsumer_BlockQueueDemo {


    public static void main(String[] args) throws Exception {

        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 消费线程启动");
            try {
                myResource.myConsumer();
                System.out.println();
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "consumer").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "prod").start();



        //main线程暂停
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("5秒钟时间到，大老板main线程 stop，活动结束");
        myResource.stop();


    }
}

class MyResource {

    private volatile boolean FLAG = true; //默认开启，进行生产+消费
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception {

        String data = null;
        boolean reValue;
        //多线程判断用 while判断
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            reValue = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
            if (reValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println(Thread.currentThread().getName() + "\t 大老板叫停了，表示flag=false，生产动作暂停");
    }


    public void myConsumer() throws Exception {
        String result = null;
        while (FLAG) {
            result = blockingQueue.poll(2, TimeUnit.SECONDS);
            if (StringUtils.isEmpty(result)) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 超过2秒没有取到蛋糕，消费退出");
                System.out.println();
                System.out.println();
                //记得一定要退出
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列蛋糕" + result + "成功");

        }

    }

    public void stop() throws Exception {
        this.FLAG = false;
    }


}
