package com.example.concurrentlearn.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: FutureTaskTest @Author: amy @Description: FutureTaskTest @Date: 2021/11/29 @Version:
 * 1.0
 */
@Slf4j
public class FutureTaskTest {

  ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

  ThreadPoolExecutor threadPoolExecutor =
      new ThreadPoolExecutor(
          2,
          5,
          1L,
          TimeUnit.SECONDS,
          new LinkedBlockingQueue<>(3),
          Executors.defaultThreadFactory(),
          new ThreadPoolExecutor.CallerRunsPolicy());

  MyTask myTask = new MyTask();
  FutureTask<Integer> futureTask = new FutureTask(myTask);

}

class MyTask implements Callable<Integer> {
  @Override
  public Integer call() throws Exception {
    int sum = 0;
    for (int i = 0; i < 1000; ++i) {
      sum += i;
    }
    Thread.sleep(3 * 1000);
    return sum;
  }
}
