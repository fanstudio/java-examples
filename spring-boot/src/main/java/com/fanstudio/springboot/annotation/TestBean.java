package com.fanstudio.springboot.annotation;

import com.fanstudio.springboot.entity.Person;
import org.springframework.context.annotation.Bean;

public class TestBean {

    @Bean
    public Person getPerson() {
        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(28);
        return person;
    }
}
