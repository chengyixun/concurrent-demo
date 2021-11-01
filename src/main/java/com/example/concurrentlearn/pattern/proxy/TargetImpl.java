package com.example.concurrentlearn.pattern.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: wangyu
 * @Date: Created 2020-12-07 09:49
 * @Description:
 * @Modified By:
 */
@Slf4j
public class TargetImpl implements Target {
    @Override
    public String execute() {
        log.info(">>>TargetImpl execute");
        return "execute";
    }
}
