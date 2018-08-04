package com.example.demo;

import com.example.demo.domain.StudentProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private StudentProperties studentProperties;

    @Test
    public void getHello() throws Exception {
        Assert.assertEquals(studentProperties.getName(), "Charlie");
        Assert.assertEquals(studentProperties.getAge().longValue(), 22L);
    }

    @Test
    public void contextLoads() {
    }
}
