package com.fanstudio.springboot.annotation;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class TestService {
    private String flag = "TestService";
}
