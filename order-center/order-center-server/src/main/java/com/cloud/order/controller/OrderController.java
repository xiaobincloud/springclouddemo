package com.cloud.order.controller;

import com.cloud.base.utils.ResponseMessage;
import com.cloud.base.utils.SuperBase;
import com.cloud.order.api.OrderApi;
import com.cloud.order.dto.RequestDTO.OrderInfoDTO;
import com.cloud.order.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaobin
 * @Title: OrderController
 * @date 2019/05/05
 * @Description:
 */
@RestController
@RequestMapping("/orderCenter")
public class OrderController extends SuperBase implements OrderApi {

    @Autowired
    private OrderService orderService;

    @Override
    @HystrixCommand
    public ResponseMessage<Boolean> createOrder(@RequestBody OrderInfoDTO orderInfoDTO) {
        return orderService.createOrder(orderInfoDTO);
    }
}
