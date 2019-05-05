package com.cloud.order.service;

import com.cloud.base.utils.ResponseMessage;
import com.cloud.order.dto.RequestDTO.OrderInfoDTO;

/**
 * @author xiaobin
 * @Title: OrderService
 * @date 2019/04/29
 * @Description:
 */
public interface OrderService {

    /**
     * 创建订单信息
     * @param orderInfoDTO
     * @return
     */
    ResponseMessage<Boolean> createOrder(OrderInfoDTO orderInfoDTO);
}
