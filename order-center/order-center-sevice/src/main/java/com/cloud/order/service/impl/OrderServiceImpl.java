package com.cloud.order.service.impl;

import com.cloud.base.utils.ResponseMessage;
import com.cloud.order.dto.RequestDTO.OrderInfoDTO;
import com.cloud.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xiaobin
 * @Title: OrderServiceImpl
 * @date 2019/04/29
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    @Transactional
    public ResponseMessage<Boolean> createOrder(OrderInfoDTO orderInfoDTO) {
        LOGGER.info("创建订单名称为:{},订单价格为:{}", orderInfoDTO.getName(), orderInfoDTO.getPrice());
        return new ResponseMessage<>(true);
    }
}
