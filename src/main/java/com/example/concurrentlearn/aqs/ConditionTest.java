package com.example.concurrentlearn.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 假设有4个线程A、B、C、D，
 * A先获取锁执行耗时操作，
 * 然后 B、C、D被插入等待队列，
 * A释放锁后唤醒B，B执行 await 操作后释放锁且阻塞自己，
 * C获取锁后调用 signal 唤醒线程B，
 * 可以看到 B被唤醒后并没有立即执行，而是等D线程任务执行完成之后才执行唤醒后的操作
 *
 * for test Condition await and signal
 */
@Slf4j
public class ConditionTest {


    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

//        new Thread(() -> new MThread(lock), "[A]").start();
//
//
//        Thread.sleep(3 * 1000);
//
//
//        new Thread(() -> new WaitThread(lock, condition), "[B]").start();
//
//        new Thread(() -> new SignalThread(lock, condition), "[C]").start();
//
//        new Thread(() -> new MThread(lock), "[D]").start();

        Thread aThread = new Thread(new MThread(lock, condition));
        aThread.setName("[A]");

        Thread waitThread = new Thread(new WaitThread(lock, condition));
        waitThread.setName("[B]");

        Thread signalThread = new Thread(new SignalThread(lock, condition));
        signalThread.setName("[C]");

        Thread dThread = new Thread(new MThread(lock, condition));
        dThread.setName("[D]");

        aThread.start();

        Thread.sleep(100);

        waitThread.start();
        signalThread.start();
        dThread.start();

    }
}

class MThread implements Runnable {
    private final ReentrantLock lock;
    private final Condition condition;

    public MThread(ReentrantLock lock,Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " 开始执行等待3s , time = " + System.currentTimeMillis());
            Thread.sleep(3 * 1000);
            System.out.println(Thread.currentThread().getName() + " 执行结束, time = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class WaitThread implements Runnable {
    private final ReentrantLock lock;
    private final Condition condition;

    public WaitThread(ReentrantLock lock, Condition condition) {
        this.condition = condition;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " >>>>开始执行 await，等待被唤醒 , time = " + System.currentTimeMillis());
            condition.await();
            System.out.println(Thread.currentThread().getName() + " >>>>被唤醒 执行结束, time = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class SignalThread implements Runnable {
    private final ReentrantLock lock;
    private final Condition condition;

    public SignalThread(ReentrantLock lock, Condition condition) {
        this.condition = condition;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " --- 开始执行 signal，去唤醒其他线程 , time = " + System.currentTimeMillis());
            condition.signal();
            System.out.println(Thread.currentThread().getName() + "  --- 执行结束, time = " + System.currentTimeMillis());
        } finally {
            lock.unlock();
        }

    }
}
