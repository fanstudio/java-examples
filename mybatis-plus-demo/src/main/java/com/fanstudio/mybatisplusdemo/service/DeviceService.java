package com.fanstudio.mybatisplusdemo.service;

import com.fanstudio.mybatisplusdemo.pojo.Device;

import java.util.List;


public interface DeviceService {
    List<Device> selectAll();

    Device getDeviceById(Integer deviceId);

    Device insertDevice(Device device);

    int deleteById(Integer id);

    int updateDevice(Device device);
}
