package com.cloud.order.config;

import com.cloud.base.eunm.ResponseMessageType;
import com.cloud.base.utils.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 订单中心全局异常处理
 */
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
    public ResponseMessage defaultErrorHandler(HttpServletRequest request, Exception e){
        LOGGER.error("{}", e);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMsg(e.getLocalizedMessage());
        responseMessage.setType(ResponseMessageType.ERROR);
        return responseMessage;
    }

}
