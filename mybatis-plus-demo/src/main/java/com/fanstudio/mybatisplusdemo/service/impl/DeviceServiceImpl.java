package com.fanstudio.mybatisplusdemo.service.impl;

import com.fanstudio.mybatisplusdemo.mapper.DeviceMapper;
import com.fanstudio.mybatisplusdemo.pojo.Device;
import com.fanstudio.mybatisplusdemo.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public List<Device> selectAll() {
        return deviceMapper.selectList(null);
    }

    @Override
    public Device getDeviceById(Integer deviceId) {
        return deviceMapper.selectById(deviceId);
    }

    @Override
    public Device insertDevice(Device device) {
        deviceMapper.insert(device);
        return device;
    }

    @Override
    public int deleteById(Integer id) {
        return deviceMapper.deleteById(id);
    }

    @Override
    public int updateDevice(Device device) {
        return deviceMapper.update(device, null);
    }
}
