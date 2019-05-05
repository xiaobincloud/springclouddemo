package com.cloud.user.api;

import com.cloud.base.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiaobin
 * @Title: UserApi
 * @date 2019/04/25
 * @Description:
 */
@Api(value = "用户服务", description = "用户服务中心")
@RequestMapping("/userCenter")
public interface UserApi {

    @ApiOperation(value="用户登录", notes="用户登录操作")
    @PostMapping(value = "/login")
    Boolean login(String userName, String password);


    @ApiOperation(value="创建订单", notes="用户创建订单")
    @PostMapping(value = "/createOrderInfo")
    ResponseMessage<Boolean> createOrderInfo();
}
