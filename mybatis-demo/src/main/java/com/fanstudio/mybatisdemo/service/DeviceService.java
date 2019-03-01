package com.fanstudio.mybatisdemo.service;

import com.fanstudio.mybatisdemo.pojo.Device;

import java.util.List;

public interface DeviceService {
    Device selectByPrimaryKey(Integer id);

    List<Device> selectAll();

    void insert(Device device);


}
