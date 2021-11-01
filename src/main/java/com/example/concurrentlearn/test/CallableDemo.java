package com.example.concurrentlearn.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: wangyu
 * @Date: Created 2020-06-21 10:25
 * @Description:
 * @Modified By:
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());

        Thread t1 = new Thread(futureTask,"AAAAA");
        t1.start();

        System.out.println(">>>> main result:"+ futureTask.get());


    }
}

class MyThread implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        System.out.println(">>>> mythread come in ");
        return 1024;
    }
}
