package com.cloud.user.client;

import com.cloud.user.api.UserApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author xiaobin
 * @Title: UserClient
 * @date 2019/04/26
 * @Description:
 */
@FeignClient("user-center-server")
public interface UserClient extends UserApi {

}
