package com.fanstudio.mybatisplusdemo.otherservice.controller;

import com.fanstudio.mybatisplusdemo.otherservice.service.OtherDeviceService;
import com.fanstudio.mybatisplusdemo.pojo.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/other-service")
public class OtherDeviceController {
    @Autowired
    private OtherDeviceService otherDeviceService;

    @GetMapping("devices")
    List<Device> getAllDevices() {
        return otherDeviceService.list(null);
    }

}
