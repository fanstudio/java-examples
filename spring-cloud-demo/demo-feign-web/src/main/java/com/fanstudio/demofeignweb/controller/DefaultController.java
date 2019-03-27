package com.fanstudio.demofeignweb.controller;

import com.fanstudio.demofeignweb.client.DefaultClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhangfan
 * @date 2019/3/27
 * @description
 */
@RestController
public class DefaultController {

    @Autowired
    private DefaultClient defaultClient;

    @GetMapping("getServiceVersion")
    public Map<String, String> getServiceInfo() {
        return defaultClient.showServiceInfo();
    }
}
