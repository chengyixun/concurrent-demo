package com.example.concurrentlearn.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: wangyu
 * @Date: Created 2020-05-28 16:48
 * @Description:
 * 读写锁： 读-读能共存
 * 读-写不能共存
 * 写-写不能共存
 * 写操作： 原子+独占，整个过程必须是完整的统一体，中间不许被分割，打断
 * ReentrantReadWriteLock
 *
 * @Modified By:
 */
public class ReadWriteLockDemo {


    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(() -> {
                myCache.put(String.valueOf(finalI), finalI);
            }, String.valueOf(i)).start();
        }

        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(() -> {
                myCache.get(String.valueOf(finalI));
            }, String.valueOf(i)).start();
        }

    }
}


class MyCache {


    private volatile Map<String, Object> map = new HashMap<>();

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入 ");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成 ");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }


    }

    public void get(String key) {

        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取中");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取结果：" + result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }

    }

}
