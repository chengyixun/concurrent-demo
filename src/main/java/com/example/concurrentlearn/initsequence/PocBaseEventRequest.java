package com.example.concurrentlearn.initsequence;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @description:
 * @author: wangyu
 * @date: Created in 2020/2/13 10:37 上午
 * @modified By:
 */
@Data
public abstract class PocBaseEventRequest  implements PocBaseEvent{
    /**
     * 会话有效性标识
     */
    @JSONField(name = "SessionId")
    private String sessionId;
}
