package com.cloud.order.api;

import com.cloud.base.utils.ResponseMessage;
import com.cloud.order.dto.RequestDTO.OrderInfoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiaobin
 * @Title: OrderApi
 * @date 2019/04/28
 * @Description:
 */
@Api(value = "订单服务", description = "订单服务中心")
@RequestMapping("/orderCenter")
public interface OrderApi {

    @PostMapping(value = "/createOrder")
    @ApiOperation(value="订单创建", notes="订单创建操作")
    ResponseMessage<Boolean> createOrder(@RequestBody OrderInfoDTO orderInfoDTO);
}
