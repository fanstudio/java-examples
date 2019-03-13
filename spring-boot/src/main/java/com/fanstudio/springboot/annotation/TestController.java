package com.fanstudio.springboot.annotation;

import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
public class TestController {

    private String flag = "TestController";
}
