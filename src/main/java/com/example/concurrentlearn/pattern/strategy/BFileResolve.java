package com.example.concurrentlearn.pattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ClassName: BFileResolve @Author: amy @Description: BFileResolve @Date: 2021/11/11 @Version: 1.0
 */
@Slf4j
@Component
public class BFileResolve implements IFileStrategy {
  @Override
  public FileTypeResolveEnum getFileType() {
    return FileTypeResolveEnum.B;
  }

  @Override
  public void resolve(Object param) {
    log.info("B 类型文件解析，参数：{}", param);
  }
}
