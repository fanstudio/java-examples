package com.fanstudio.springboot.controller;

import com.fanstudio.springboot.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;
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
    public Map<String,String> info() throws SQLException {
        Map<String,String> map = new HashMap<>();
        map.put("version", "v.0.0.1");
        log.debug("enter info");
        return map;
    }

    @GetMapping("person")
    public Person getPerson() {
        return new Person();
    }


}
