package com.fanstudio.springboot.service.impl;

import com.fanstudio.springboot.mapper.DeviceMapper;
import com.fanstudio.springboot.pojo.Device;
import com.fanstudio.springboot.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Device getDeviceById(Integer id) {
        return deviceMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public Device insertDevice(Device device) {
        deviceMapper.insert(device);
        return device;
    }
}
