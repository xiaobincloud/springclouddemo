package com.cloud.user;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaobin
 * @Title: UserClientAutoConfiguration
 * @date 2019/04/26
 * @Description:
 */
@Configuration
@EnableFeignClients("com.cloud.user.client")
public class UserClientAutoConfiguration {
}
