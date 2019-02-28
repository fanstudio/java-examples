package com.fanstudio.mapperdemo.controller;

import com.fanstudio.mapperdemo.pojo.Device;
import com.fanstudio.mapperdemo.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    private DataSource dataSource;

    @Autowired
    private DeviceService deviceService;

    @RequestMapping("info")
    Map<String,String> info() throws SQLException {
        Map<String,String> map = new HashMap<>();
        map.put("version", "v.0.0.1");
        map.put("datasource", dataSource.getConnection().toString());
        log.debug("enter info");
        return map;
    }

    @RequestMapping("device/{id}")
    Device device(@PathVariable Integer id) {
        return deviceService.getDeviceById(id);
    }

    @RequestMapping("device")
    Device device(Device device) throws Exception {
        return deviceService.insertDevice(device);
    }
}
