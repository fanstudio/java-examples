package com.fanstudio.mybatisdemo.mapper;

import com.fanstudio.mybatisdemo.pojo.Device;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DeviceMapper {

    @Select("SELECT `id`, `service_name`, `description`, `ip_address`, `port_type`, `port` FROM tb_device WHERE `id`=#{id}")
    Device selectByPrimaryKey(@Param("id") Integer id);

    @Select("SELECT `id`, `service_name`, `description`, `ip_address`, `port_type`, `port` FROM tb_device")
    List<Device> selectAll();

    @Insert("INSERT INTO tb_device VALUES(NULL, #{serviceName},#{description},#{ipAddress},#{portType},#{port})")
    void insert(Device device);

}
