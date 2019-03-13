package com.fanstudio.springboot.annotation;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TestClass {
    private String flag = "TestClass";
}
