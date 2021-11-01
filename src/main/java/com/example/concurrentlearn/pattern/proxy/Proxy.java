package com.example.concurrentlearn.pattern.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: wangyu
 * @Date: Created 2020-12-07 09:50
 * @Description:
 * @Modified By:
 */
@Slf4j
public class Proxy implements Target {

    private Target target;

    public Proxy(Target target) {
        this.target = target;
    }

    @Override
    public String execute() {
        log.info(">>>perProcess");
        String result = target.execute();
        log.info(">>>postProcess");
        return result;
    }
}
