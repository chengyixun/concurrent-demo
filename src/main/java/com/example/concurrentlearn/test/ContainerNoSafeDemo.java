package com.example.concurrentlearn.test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author: wangyu
 * @Date: Created 2020-05-25 22:26
 * @Description: 集合不安全的安全 ArrayList
 * @Modified By:
 */
public class ContainerNoSafeDemo {

    public static void main(String[] args) {
        listNotSave();

        setNotSafe();

        mapNotSafe();
    }

    /**
     * HashMap & ConcurrentHashMap
     */
    private static void mapNotSafe() {
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    private static void setNotSafe() {
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }

        new HashSet<>();
    }

    /**
     * 1 故障现象
     *   java.util.ConcurrentModificationException
     *
     * 2 导致原因
     *    并发争抢修改导致
     *    一个人正在写入，宁外一个人过来抢夺，导致数据不一致异常。并发修改异常
     *
     *
     * 3 解决方案
     *   3.1  new Vector<>();  synchronized
     *   3.2  Collections.synchronizedList(new ArrayList<>());
     *   3.3  new CopyOnWriteArrayList<>();
     * 4 优化建议

     */
    private static void listNotSave() {
        // List<String> list = Arrays.asList("a", "b", "c");
        // list.forEach(System.out::println);

        List<String> strings = new ArrayList<>();

        List<String> s2 = new CopyOnWriteArrayList<>();
        List<String> s3 = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                strings.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(strings);
            }, String.valueOf(i)).start();
        }
        System.out.println(strings);

       }
}
