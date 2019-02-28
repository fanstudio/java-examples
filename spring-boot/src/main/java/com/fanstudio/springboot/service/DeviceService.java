package com.fanstudio.springboot.service;

import com.fanstudio.springboot.pojo.Device;

public interface DeviceService {
    Device getDeviceById(Integer id);
    Device insertDevice(Device device);
}
