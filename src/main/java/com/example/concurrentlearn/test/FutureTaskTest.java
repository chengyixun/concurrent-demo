package com.example.concurrentlearn.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: FutureTaskTest @Author: amy @Description: FutureTaskTest @Date: 2021/11/29 @Version:
 * 1.0
 *
 * <p>1.Future机制并不是对Runnable的革名，只是对Runnable的扩展。Callable、Future、FutureTask的配合，解决Runnable无返回值的问题。
 *
 * <p>2.Callable、Future、RunnableFuture都是接口，是FutureTask在背后默默的干活。
 */
@Slf4j
public class FutureTaskTest {

  private static ThreadPoolExecutor threadPoolExecutor =
      new ThreadPoolExecutor(
          2,
          5,
          1L,
          TimeUnit.SECONDS,
          new LinkedBlockingQueue<>(3),
          Executors.defaultThreadFactory(),
          new ThreadPoolExecutor.CallerRunsPolicy());

  public static void main(String[] args) {
    /***
     * 方式一
     */
    MyTask myTask = new MyTask();
    FutureTask<Integer> futureTask = new FutureTask(myTask);
    threadPoolExecutor.submit(futureTask);

    /** 方式二 */
    // new Thread(futureTask).start();

    try {
      // 拿结果方式一
      Integer result1 = futureTask.get();
      log.info("T:{},result1:{}", Thread.currentThread().getName(), result1);
      // 拿结果 方式二 设置超时时间，最多等5秒
      Integer result2 = futureTask.get(5, TimeUnit.SECONDS);
      log.info("T:{},result2:{}", Thread.currentThread().getName(), result2);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      threadPoolExecutor.shutdown();
    }
  }
}

class MyTask implements Callable<Integer> {
  @Override
  public Integer call() throws Exception {
    int sum = 0;
    for (int i = 0; i < 1000; ++i) {
      sum += i;
    }
    Thread.sleep(5 * 1000);
    return sum;
  }
}
