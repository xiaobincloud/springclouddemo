package com.cloud.order;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaobin
 * @Title: OrderClientAutoConfiguration
 * @date 2019/04/29
 * @Description:
 */
@Configuration
@EnableFeignClients("com.cloud.order.client")
public class OrderClientAutoConfiguration {
}
