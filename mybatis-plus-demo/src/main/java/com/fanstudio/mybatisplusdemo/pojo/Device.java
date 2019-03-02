package com.fanstudio.mybatisplusdemo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName("tb_device")
public class Device implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String serviceName;
    private String description;
    private String ipAddress;
    private Integer portType;
    private Integer port;
}
