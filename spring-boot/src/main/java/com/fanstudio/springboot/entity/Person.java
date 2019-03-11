package com.fanstudio.springboot.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangfan
 * @date 2019/3/11
 * @description
 */
@Data
public class Person implements Serializable {
    private String name;
    private Integer age;
}
