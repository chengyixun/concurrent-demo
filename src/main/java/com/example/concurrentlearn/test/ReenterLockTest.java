package com.example.concurrentlearn.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: wangyu
 * @Date: Created 2020-05-26 20:47
 * @Description: 可重入锁 又叫递归锁
 * 指的是同一个线程外层函数获得锁之后，内层递归函数仍然能获得该锁的代码，
 * 在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
 * @Modified By:
 */
public class ReenterLockTest {

    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(() -> {
            phone.sendMsg();
        }, "T1").start();

        new Thread(() -> {
            phone.sendMsg();
        }, "T2").start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();

        Thread t3 = new Thread(phone, "T3");
        Thread t4 = new Thread(phone, "T4");
        t3.start();
        t4.start();

    }
}


class Phone implements Runnable {

    public synchronized void sendMsg() {
        System.out.println(Thread.currentThread().getName() + "\t sendMsg");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName() + "\t sendEmail");
    }

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    public void get() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t ##invoke get ");
            set();
        } finally {
            lock.unlock();
        }
    }


    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t ####invoke set ");
        } finally {
            lock.unlock();
        }
    }
}