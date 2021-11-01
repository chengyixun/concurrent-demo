package com.example.concurrentlearn;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ConcurrentLearnApplicationTests {

  @Test
  void contextLoads() {}

  /** 引入 ContiPerf 进行性能测试 */
  @Rule public ContiPerfRule contiPerfRule = new ContiPerfRule();

  /**
   * 10个线程，执行10次
   */
  @Test
  @PerfTest(invocations = 100,threads = 10)
  public void test(){
    System.out.println();
  }
}
