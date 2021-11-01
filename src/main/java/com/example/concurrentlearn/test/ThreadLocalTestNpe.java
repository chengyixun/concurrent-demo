package com.example.concurrentlearn.test;

/**
 * {@link ThreadLocalTestNpe}
 *
 * @author <a href="mailto:liyaohui.wang@yunlsp.com">Liyaohui wang</a>
 * @version ${project.version} - 2021-04-20
 */
public class ThreadLocalTestNpe {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void set() {
        threadLocal.set(1L);
    }

    public static long get() {
        return threadLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            set();
            System.out.println(get());
        }).start();

        Thread.sleep(100);
        System.out.println(get());
    }
}

/**
 * 输出 1后，NullPointerException
 * 两个线程，子线程 输出1 ，
 * 主线程 为什么空指针异常 ？
 *    ThreadLocal里的泛型是Long，
 *    get却是基本类型，这需要拆箱操作的
 *    ，也就是会执行null.longValue()的操作，
 *    这绝逼空指针了。
 *
 *
 */