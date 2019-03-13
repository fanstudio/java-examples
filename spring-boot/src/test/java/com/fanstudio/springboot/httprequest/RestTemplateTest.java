package com.fanstudio.springboot.httprequest;

import com.fanstudio.springboot.entity.Person;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTest {

    @Test
    public void testGet() {
        RestTemplate restTemplate = new RestTemplate();
        Person person = restTemplate.getForObject("http://localhost/person", Person.class);
        System.out.println(person);
    }
}
