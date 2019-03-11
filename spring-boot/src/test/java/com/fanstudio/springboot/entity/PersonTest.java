package com.fanstudio.springboot.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.FileOutputStream;

/**
 * @author zhangfan
 * @date 2019/3/11
 * @description
 */
public class PersonTest {

    /**
     * 测试Jackson
     */
    @Test
    public void testJackSon() {
        ObjectMapper objectMapper = new ObjectMapper();

        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(18);

        try {
            // bytes是{"name":"zhangsan","age":18}的字符串的getbytes结果
            byte[] bytes = objectMapper.writeValueAsBytes(person);
            FileOutputStream outputStream = new FileOutputStream("d:/test.data");
            outputStream.write(bytes);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
