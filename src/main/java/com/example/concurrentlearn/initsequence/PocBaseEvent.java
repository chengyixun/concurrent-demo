package com.example.concurrentlearn.initsequence;

import com.alibaba.fastjson.JSONObject;

/**
 * @description:
 * @author: wangyu
 * @date: Created in 2020/2/12 下午1:43
 * @modified By:
 */
public interface PocBaseEvent {

    int getCode();


    default JSONObject buidRequestBody() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", getCode());
        jsonObject.put("msg", this);
        return jsonObject;

    }
}
