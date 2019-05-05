package com.cloud.user.controller;

import com.cloud.base.utils.ResponseMessage;
import com.cloud.base.utils.SuperBase;
import com.cloud.order.client.OrderClient;
import com.cloud.order.dto.RequestDTO.OrderInfoDTO;
import com.cloud.user.api.UserApi;
import com.cloud.user.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 用户服务中心
 * @author xiaobin
 * Created by xiaobin on 2017/7/13
 * Copyright (c) 2016-2019
 */
@RestController
public class UserController extends SuperBase implements UserApi {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderClient orderClient;

    @Override
    @HystrixCommand
    public Boolean login(String userName, String password) {
        return userService.loginUser(userName, password);
    }

    @Override
    @HystrixCommand
    public ResponseMessage<Boolean> createOrderInfo() {
        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
        orderInfoDTO.setName("用户创建");
        orderInfoDTO.setPrice(new BigDecimal("1.25"));
        return orderClient.createOrder(orderInfoDTO);
    }
}
