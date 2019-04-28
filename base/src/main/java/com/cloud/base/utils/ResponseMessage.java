package com.cloud.base.utils;

import com.cloud.base.eunm.CommonAttribute;
import com.cloud.base.eunm.ResponseMessageType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 服务端响应信息
 * @author xiaobin
 * 成都友漾健康科技有限公司
 * Created by xiaobin on 2017/7/12
 * Copyright (c) 2016-2019
 */
@ApiModel(value = "服务端响应信息", description = "返回响应数据信息")
public class ResponseMessage <T> implements Serializable{

    @ApiModelProperty(value = "响应类型 success warn error", required = true)
    private ResponseMessageType type;

    @ApiModelProperty(value = "响应信息", required = true)
    private String msg;

    private T data;

    public ResponseMessage() {
    }

    public ResponseMessage(String msg) {
        this.msg = msg;
    }

    public ResponseMessage(ResponseMessageType type, String msg) {
        this.type = type;
        this.msg = msg;
    }

    public ResponseMessage(T data) {
        this.data = data;
        this.type = ResponseMessageType.SUCCESS;
        this.msg= CommonAttribute.STAFF_SUCCESS;
    }


    public ResponseMessageType getType() {
        return type;
    }

    public void setType(ResponseMessageType type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public static ResponseMessage buildSuccess(){
        return new ResponseMessage(ResponseMessageType.SUCCESS,"操作成功");
    }

    public static ResponseMessage buildError(){
        return new ResponseMessage(ResponseMessageType.ERROR,"操作失败");
    }


}
