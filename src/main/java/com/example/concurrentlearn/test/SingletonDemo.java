package com.example.concurrentlearn.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: wangyu
 * @Date: Created 2020-05-24 20:53
 * @Description: 单机版本的下的单例模式
 * @Modified By:
 */
public class SingletonDemo {

    //加上volatile禁止指令重排
    private static volatile SingletonDemo instance = null;


    public SingletonDemo() {
        System.out.println("ThreadName:" + Thread.currentThread().getName() + "我是构造方法SingletonDemo()");
    }

    //DCL（double check lock 双端检索模式）== 前后共过2次安检
    //不一定安全，原因是有指令重排的情况下
    public static synchronized SingletonDemo getInstance() {
        if (instance == null) {
            //同步代码块
            synchronized (SingletonDemo.class) {

                if (instance == null) {
                    instance = new SingletonDemo();
                }

            }

        }
        return instance;
    }

   /*单机版多线程下 加了synchronized 可以解决问题，但是多机版下(多并发)锁住整个方法会大量阻塞 不推荐
   public static synchronized SingletonDemo getInstance() {
        if (instance == null) {
            instance = new SingletonDemo();
        }
        return instance;
    }*/

    public static void main(String[] args) {
        //单线程（main线程的操作动作） 因为只打出了一次构造方法，所以只new了一次
       /* System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
*/
        //并发多线程后，情况就发生变化了
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
