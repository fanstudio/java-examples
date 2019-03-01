package com.fanstudio.mybatisdemo.controller;

import com.fanstudio.mybatisdemo.pojo.Device;
import com.fanstudio.mybatisdemo.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Admin
 * @date 2019/2/28
 * @description
 */
@RestController
@Slf4j
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping("/device/{id}")
    Device getDeviceById(@PathVariable Integer id) {
        return deviceService.selectByPrimaryKey(id);
    }

    @RequestMapping("/device")
    List<Device> selectAllDevice() {
        return deviceService.selectAll();
    }

    @RequestMapping("/addDevice")
    void insertDevice(Device device) {
        deviceService.insert(device);
    }

}
