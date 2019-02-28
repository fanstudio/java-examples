package com.fanstudio.springboot.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @author Admin
 * @date 2019/2/28
 * @description
 */
@Data
@Table(name = "tb_device")
public class Device implements Serializable {
    @Id // 指定主键
    @KeySql(useGeneratedKeys = true) // 主键自增回显
    private Integer id;
    private String serviceName;
    private String description;
    private String ipAddress;
    private Integer portType;
    private Integer port;

    @Transient  // 该数据不保存到数据库
    private String testFiled;
}
