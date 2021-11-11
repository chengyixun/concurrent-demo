package com.example.concurrentlearn.pattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ClassName: DefaultFileResolve @Author: amy @Description: DefaultFileResolve @Date:
 * 2021/11/11 @Version: 1.0
 */
@Slf4j
@Component
public class DefaultFileResolve implements IFileStrategy {
  @Override
  public FileTypeResolveEnum getFileType() {
    return FileTypeResolveEnum.DEFAULT;
  }

  @Override
  public void resolve(Object param) {
    log.info("默认 类型文件解析，参数：{}", param);
  }
}
