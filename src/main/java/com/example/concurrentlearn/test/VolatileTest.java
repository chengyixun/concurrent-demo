package com.example.concurrentlearn.test;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: wangyu
 * @Date: Created 2020-05-24 14:04
 * @Description:
 * @Modified By:
 */
@Slf4j
public class VolatileTest {

    public static void main(String[] args) {
        // seeOkByVolatile();

        seeVolatileAtomic();

    }

    /**
     * 2.volatile不保证原子性
     * 3.why
     * 4.如何解决？
     *    使用sync不推荐
     *
     *
     */
    private static void seeVolatileAtomic() {
        MyData myData = new MyData();
        //20个线程，每个线程加1000次，算下来，结果num=20*1000 = 2w才对，
        for (int i = 0; i < 20; i++) {

            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.addMyAtomic();
                }

            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        log.info("ThreadName:{},Int totalNum:{}", Thread.currentThread().getName(), myData.getNum());
        log.info("ThreadName:{},Atomic totalNum:{}", Thread.currentThread().getName(), myData.getAtomicInteger());
        //ThreadName:main, totalNum:18718
    }

    /**
     * 1、 验证volatile的可见性
     */
    private static void seeOkByVolatile() {
        MyData myData = new MyData();

        new Thread(() -> {
            log.info("threadName:{} come in,current mun:{}", Thread.currentThread().getName(), myData.getNum());
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.add();
            log.info("threadName:{} ,change num:{}", Thread.currentThread().getName(), myData.getNum());

        }, "AA").start();
        //当程序调用start()方法时，会创建一个新线程，然后执行run()方法


        while (myData.getNum() == 0) {
            /**
             * 若线程不可见的话，main线程会一直卡在while里面
             *
             */
        }

        log.info("task over,threadName:{} ,num:{}", Thread.currentThread().getName(), myData.getNum());
    }


}

@Data
class MyData {

    volatile int num = 0;

    public void add() {
        this.num = 60;
    }

    public void addPlusPlus() {
        this.num++;
    }

    AtomicInteger  atomicInteger = new AtomicInteger();


    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }

}