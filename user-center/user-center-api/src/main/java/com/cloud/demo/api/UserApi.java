package com.cloud.demo.api;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiaobin
 * @Title: UserApi
 * @date 2019/04/25
 * @Description:
 */
@Api(value = "用户服务", description = "用户服务中心")
@RequestMapping("/userCenter")
public interface UserApi {
}
