package com.example.concurrentlearn.pattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ClassName: AFileResolve
 * @Author: amy
 * @Description: AFileResolve A 类型策略具体实现
 * @Date: 2021/11/11 @Version: 1.0
 */
@Slf4j
@Component
public class AFileResolve implements IFileStrategy {

  @Override
  public FileTypeResolveEnum getFileType() {
    return FileTypeResolveEnum.A;
  }

  @Override
  public void resolve(Object param) {
    log.info("A 类型文件解析，参数：{}", param);
  }
}
