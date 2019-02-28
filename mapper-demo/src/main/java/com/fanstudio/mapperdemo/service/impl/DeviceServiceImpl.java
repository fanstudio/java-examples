package com.fanstudio.mapperdemo.service.impl;

import com.fanstudio.mapperdemo.mapper.DeviceMapper;
import com.fanstudio.mapperdemo.pojo.Device;
import com.fanstudio.mapperdemo.service.DeviceService;
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
    public Device insertDevice(Device device) throws Exception {
        deviceMapper.insert(device);
        int a = 0;
        System.out.println(1 / a);
        return device;
    }
}
