package com.fanstudio.demoweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class DefaultController {


    @GetMapping("/version")
    public Map<String, String> showServerInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("version", "v0.0.1");
        return map;
    }

    @GetMapping("/serviceVersion")
    public Map<String, String> showServiceInfo() {
        log.debug("enter showServiceInfo");
        RestTemplate restTemplate = new RestTemplate();
        Map map = restTemplate.getForObject("http://localhost:9091/version", Map.class);
        return map;
    }
}
