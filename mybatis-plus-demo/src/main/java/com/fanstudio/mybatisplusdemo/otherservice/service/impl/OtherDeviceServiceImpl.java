package com.fanstudio.mybatisplusdemo.otherservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fanstudio.mybatisplusdemo.mapper.DeviceMapper;
import com.fanstudio.mybatisplusdemo.otherservice.service.OtherDeviceService;
import com.fanstudio.mybatisplusdemo.pojo.Device;
import org.springframework.stereotype.Service;

@Service
public class OtherDeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements OtherDeviceService {
}
