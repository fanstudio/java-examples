package com.fanstudio.mybatisdemo.controller;

import com.fanstudio.mybatisdemo.pojo.Device;
import com.fanstudio.mybatisdemo.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Admin
 * @date 2019/2/28
 * @description
 */
@RestController
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping("/device/{id}")
    Device device(@PathVariable Integer id) {
        return  deviceService.selectByPrimaryKey(id);
    }

}
