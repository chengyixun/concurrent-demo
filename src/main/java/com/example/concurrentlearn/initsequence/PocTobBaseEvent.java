package com.example.concurrentlearn.initsequence;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @description:
 * @author: apple
 * @date: Created in 2020/2/12 上午10:42
 * @modified By:
 */
public interface PocTobBaseEvent {
    /**
     * 请求报文Code事务码
     *
     * @return code
     */
    @JSONField(serialize = false)
    int getCode();
}
