package com.example.concurrentlearn.initsequence;

import lombok.Data;

/**
 * @description:
 * @author: apple
 * @date: Created in 2020/2/12 上午10:47
 * @modified By:
 */
@Data
public class PocTobCreateChannelRequest  implements  PocTobBaseEvent {

    //随意写
    @Override
    public int getCode() {
        return 11111;
    }

    /**
     * 企业id
     */
    private Long orgId;
    /**
     * 频道名称
     */
    private String gname;
}
