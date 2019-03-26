package com.fanstudio.demoservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class DefaultController {


    @GetMapping("/version")
    public Map<String, String> showServerInfo() {
        log.debug("enter showServerInfo");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap();
        map.put("serviceVersion", "v0.0.1");
        return map;
    }
}
