package com.fanstudio.mybatisdemo.mapper;

import com.fanstudio.mybatisdemo.pojo.Device;

public interface DeviceMapper {
    Device selectByPrimaryKey(Integer id);
}
