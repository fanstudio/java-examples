package com.fanstudio.demofeignweb.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @author zhangfan
 * @date 2019/3/27
 * @description
 */

@FeignClient(value = "demo-service", fallback = DefaultClientFallBack.class)
public interface DefaultClient {

    @GetMapping("version")
    Map<String, String> showServiceInfo();
}
