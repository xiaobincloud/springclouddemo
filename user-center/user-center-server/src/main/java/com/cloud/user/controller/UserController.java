package com.cloud.user.controller;

import com.cloud.base.utils.SuperBase;
import com.cloud.user.api.UserApi;
import com.cloud.user.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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

    @Override
    @HystrixCommand
    public Boolean login(String userName, String password) {
        return userService.loginUser(userName, password);
    }
}
