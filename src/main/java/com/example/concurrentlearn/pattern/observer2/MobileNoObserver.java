package com.example.concurrentlearn.pattern.observer2;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: MobileNoObserver @Author: amy @Description: MobileNoObserver @Date:
 * 2021/11/11 @Version: 1.0
 */
@Slf4j
public class MobileNoObserver implements Observer {
  @Override
  public void doEvent() {
    log.info("发送手机短信");
  }
}
