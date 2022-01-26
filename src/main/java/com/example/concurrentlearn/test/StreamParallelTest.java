package com.example.concurrentlearn.test;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @ClassName: StreamParallelTest @Author: amy @Description: StreamParallelTest @Date:
 * 2022/1/26 @Version: 1.0
 */
@Slf4j
public class StreamParallelTest {

  public static void main(String[] args) {
    /**
     * 如果某个生产者生产了许多重量级的任务（耗时很长），那么其他任务毫无疑问将会没有工作线程可用；更可怕的事情是这些工作线程正在进行IO阻塞。
     * 当第一个并行流先率先获得worker线程的使用权，第二个并行流变为串行
     */
    Thread thread = new Thread(StreamParallelTest::streamTest);
    Thread thread1 = new Thread(StreamParallelTest::streamTest2);
    thread.start();
    thread1.start();

    try {
      thread.join();
      thread1.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void streamTest() {
    List<Integer> numbers = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
    numbers.parallelStream()
        .forEach(
            num -> {
              System.out.println("第一次请求并行:" + Thread.currentThread().getName() + ">>" + num);
              try {
                Thread.sleep(5 * 1000);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            });
  }

  public static void streamTest2() {
    List<Integer> numbers = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
    numbers.parallelStream()
        .forEach(
            num -> {
              System.out.println("第二次请求并行:" + Thread.currentThread().getName() + ">>" + num);
              try {
                Thread.sleep(5 * 1000);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            });
  }
}
