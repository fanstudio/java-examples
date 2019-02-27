package com.fanstudio.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Admin
 * @date 2019/2/27
 * @description
 */
@Slf4j
@RestController
public class DefaultController {

    @RequestMapping("info")
    Map<String,String> info() {
        Map<String,String> map = new HashMap<>();
        map.put("version", "v.0.0.1");
        log.debug("enter info");
        return map;
    }
}
