package com.fanstudio.mybatisplusdemo.controller;

import com.fanstudio.mybatisplusdemo.pojo.Device;
import com.fanstudio.mybatisplusdemo.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping("/info")
    public Map<String, String> info() {
        Map<String, String> map = new HashMap<>();
        map.put("version", "v0.0.1");
        return map;
    }

    @GetMapping("/devices")
    public List<Device> getAllDevices() {
        return deviceService.selectAll();
    }

    @GetMapping("/devices/{deviceId}")
    public Device getDeviceById(@PathVariable Integer deviceId) {
        return deviceService.getDeviceById(deviceId);
    }

    @PostMapping("/devices")
    public Device insertDevice(Device device) {
        log.debug(device.toString());
        return deviceService.insertDevice(device);
    }

    @DeleteMapping("/devices/{deviceId}")
    public Map<String, String> deleteDeviceById(@PathVariable Integer deviceId) {
        Map<String, String> map = new HashMap<>();
        map.put("result", "" + deviceService.deleteById(deviceId));
        return map;
    }

    @PutMapping("/devices")
    public Map<String, String> updateDevice(Device device) {
        Map<String, String> map = new HashMap<>();
        map.put("result", "" + deviceService.updateDevice(device));
        return map;
    }

}
