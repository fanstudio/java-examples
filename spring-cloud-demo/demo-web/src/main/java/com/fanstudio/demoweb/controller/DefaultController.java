package com.fanstudio.demoweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class DefaultController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/serviceVersion")
    public Map<String, String> showServiceInfo() {
        log.debug("enter showServiceInfo");
        // 通过注册中心获取服务端信息
        List<ServiceInstance> instances = discoveryClient.getInstances("demo-service");
        ServiceInstance serviceInstance = instances.get(0);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        // 拼接地址，并请求
        String url = "http://" + host + ":" + port + "/version";
        RestTemplate restTemplate = new RestTemplate();
        Map map = restTemplate.getForObject(url, Map.class);

        return map;
    }


    @GetMapping("/autoShowServiceInfo")
    public Map<String, String> autoShowServiceInfo() {
        log.debug("enter autoShowServiceInfo");
        // 请求地址不用使用ip端口直接写服务名称
        String url = "http://demo-service/version";
        Map map = restTemplate.getForObject(url, Map.class);

        return map;
    }
}
