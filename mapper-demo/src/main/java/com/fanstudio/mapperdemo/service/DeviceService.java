package com.fanstudio.mapperdemo.service;

import com.fanstudio.mapperdemo.pojo.Device;

public interface DeviceService {
    Device getDeviceById(Integer id);
    Device insertDevice(Device device) throws Exception;
}
