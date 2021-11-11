package com.example.concurrentlearn.pattern.strategy;

/**
 * @ClassName: IFileStrategy @Author: amy @Description: IFileStrategy @Date: 2021/11/11 @Version:
 * 1.0
 */
public interface IFileStrategy {

  /**
   * 获取文件解析类型
   *
   * @return
   */
  FileTypeResolveEnum getFileType();

  /**
   * 具体的解析方法
   *
   * @param param
   */
  void resolve(Object param);
}
