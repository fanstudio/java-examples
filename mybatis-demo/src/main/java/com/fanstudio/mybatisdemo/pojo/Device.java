package com.fanstudio.mybatisdemo.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Admin
 * @date 2019/2/28
 * @description
 */
@Data
public class Device implements Serializable {
    private Integer id;
    private String serviceName;
    private String description;
    private String ipAddress;
    private Integer portType;
    private Integer port;
}
