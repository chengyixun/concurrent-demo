package com.example.concurrentlearn.test;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wangyu
 * @Date: Created 2020-07-05 16:40
 * @Description: 死锁是两个或者两个以上的进程在执行过程中
 * 因为争夺资源而造成的一种互相等待的现象
 * 若无外力干涉下 他们将无法推进下去
 * @Modified By:
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        String a = "lockA";
        String b = "lockB";
        new Thread(new HoldLockThread(a, b), "ThreadA").start();
        new Thread(new HoldLockThread(b, a), "ThreadB").start();

    }
}

@Data
@AllArgsConstructor
class HoldLockThread implements Runnable {

    private String lockA;

    private String lockB;

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockA + "\t 尝试获取： " + lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockB + "\t 尝试获取： " + lockA);
            }
        }

    }
}
