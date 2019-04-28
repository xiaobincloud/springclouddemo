package com.cloud.user.service.impl;

import com.cloud.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xiaobin
 * @Title: UserServiceImpl
 * @date 2019/04/26
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Transactional
    @Override
    public Boolean loginUser(String userName, String password) {
        LOGGER.info("账号:{},密码为:{}", userName, password);
        return true;
    }
}
