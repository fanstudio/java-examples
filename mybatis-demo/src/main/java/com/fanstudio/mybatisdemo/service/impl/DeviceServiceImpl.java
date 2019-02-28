package com.fanstudio.mybatisdemo.service.impl;

import com.fanstudio.mybatisdemo.mapper.DeviceMapper;
import com.fanstudio.mybatisdemo.pojo.Device;
import com.fanstudio.mybatisdemo.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Admin
 * @date 2019/2/28
 * @description
 */
@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public Device selectByPrimaryKey(Integer id) {
        return deviceMapper.selectByPrimaryKey(1);
    }
}
