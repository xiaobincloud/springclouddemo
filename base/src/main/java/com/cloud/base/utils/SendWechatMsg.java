package com.cloud.base.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaobin
 * 成都友漾健康科技有限公司
 * Created by xiaobin on 2017/9/25
 * Copyright (c) 2016-2019
 */
public class SendWechatMsg {
    /**
     * 发送消息
     * @param openId
     * @param dataObj
     * @return
     */
    public static String sendMessage(String openId, Object dataObj, String templateId, String token) throws IOException {
        String sendMsgUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+token;
        Map<String, Object> data = new HashMap<>();
        data.put("touser", openId);
        data.put("template_id", templateId);
        data.put("topcolor", "#FF0000");
        data.put("data", dataObj);
        return HttpClient.doPost(sendMsgUrl, data, null);
    }
}
