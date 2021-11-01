package com.example.concurrentlearn.initsequence;

import com.alibaba.fastjson.JSONObject;
import lombok.Builder;
import lombok.Data;

/**
 * @description:
 * @author: wangyu
 * @date: Created in 2020/2/12 下午1:57
 * @modified By:
 */
@Data
@Builder
public class PocCreateChannelRequest extends PocBaseEventRequest{
    @Override
    public int getCode() {
        return 2222;
    }
    /**
     * 企业id
     */
    private Long orgId;
    /**
     * 频道名称
     */
    private String gname;


    //测试构建的结构体
    public static void main(String[] args) {
        PocCreateChannelRequest request = PocCreateChannelRequest.builder()
                .gname("测试1")
                .orgId(2L)
                .build();
        request.setSessionId("sessionIdxxxx");

        JSONObject jsonObject = request.buidRequestBody();

        System.out.println(jsonObject);
    }
}
