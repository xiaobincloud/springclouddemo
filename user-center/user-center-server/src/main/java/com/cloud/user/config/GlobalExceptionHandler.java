package com.cloud.user.config;

import com.cloud.base.eunm.ResponseMessageType;
import com.cloud.base.utils.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xiaobin
 * Created by xiaobin on 2019/4/28
 * Copyright (c) 2019-2021
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 系统异常处理
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseMessage defaultErrorHandler(HttpServletRequest request, Exception e) {
        LOGGER.error("user center handler error:{}", e, e.getMessage());
        return new ResponseMessage(ResponseMessageType.ERROR, e.getLocalizedMessage());
    }
}
