package com.fanstudio.mybatisdemo.service;

import com.fanstudio.mybatisdemo.pojo.Device;

public interface DeviceService {
    Device selectByPrimaryKey(Integer id);
}
