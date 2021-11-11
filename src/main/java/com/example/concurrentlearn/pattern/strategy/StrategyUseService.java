package com.example.concurrentlearn.pattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: StrategyUseService @Author: amy @Description: StrategyUseService @Date:
 * 对外提供的时候 可以使用
 * StrategyUseService.resolveFile() 2021/11/11 @Version: 1.0
 */
@Slf4j
@Service
public class StrategyUseService implements ApplicationContextAware {

  private Map<FileTypeResolveEnum, IFileStrategy> iFileStrategyMap = new ConcurrentHashMap<>();

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    Map<String, IFileStrategy> beans = applicationContext.getBeansOfType(IFileStrategy.class);
    beans
        .values()
        .forEach(iFileStrategy -> iFileStrategyMap.put(iFileStrategy.getFileType(), iFileStrategy));
  }

  /**
   * 解析文件
   *
   * @param fileTypeResolveEnum
   * @param param
   */
  public void resolveFile(FileTypeResolveEnum fileTypeResolveEnum, Object param) {
    IFileStrategy iFileStrategy = iFileStrategyMap.get(fileTypeResolveEnum);
    log.info("当前策略类型：{}", fileTypeResolveEnum);
    if (Objects.isNull(iFileStrategy)) {
      return;
    }
    iFileStrategy.resolve(param);
  }
}
