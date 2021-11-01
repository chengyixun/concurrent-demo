package com.example.concurrentlearn.initsequence;

import lombok.Data;

/**
 * @description:
 * @author: apple
 * @date: Created in 2020/2/12 上午10:44
 * @modified By:
 */
@Data
public class PocTobEventRequest {

    /**
     * 业务系统标识，应用注册获得
     */
    private String appId;

    /**
     * 业务系统访问密码，应用注册获得
     */
    private String appKey;

    /**
     * 指令操作码，具体参考指令操作列表
     */
    private Integer code;

    /**
     * 数字签名,按参数名字母顺序+appKey做md5
     */
    private String sign;

    private PocTobBaseEvent data;

    public PocTobEventRequest(PocTobBaseEvent data) {
        this.code = data.getCode();
        this.data = data;
        System.out.println("PocTobEventRequest 有参构造器");
    }

    public PocTobEventRequest() {
        System.out.println("PocTobEventRequest 无参构造器");
    }

   /* public void setData(PocTobBaseEvent data){
        this.data = data;
        System.out.println("PocTobEventRequest setData()方法");
    }*/

   //测试代码
    public static void main(String[] args) {
        PocTobCreateChannelRequest request = new PocTobCreateChannelRequest();
        request.setGname("gname11");
        request.setOrgId(11L);
        PocTobEventRequest eventRequest = new PocTobEventRequest(request);
        System.out.println(eventRequest);


    }

}
