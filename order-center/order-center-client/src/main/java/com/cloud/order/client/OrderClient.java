package com.cloud.order.client;

import com.cloud.order.api.OrderApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author xiaobin
 * @Title: OrderClient
 * @date 2019/04/29
 * @Description:
 */
@FeignClient("order-center-server")
public interface OrderClient extends OrderApi {
}
