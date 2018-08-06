package com.example.demo;

import com.example.demo.domain.StudentProperties;
import com.example.demo.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

    @Autowired
    private StudentProperties studentProperties;

    @Test
    public void getHello() throws Exception {
        Assert.assertEquals(studentProperties.getName(), "Charlie");
        Assert.assertEquals(studentProperties.getAge().longValue(), 22L);
    }

    /*@Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Test
    public void testRedis() throws Exception {
        // 保存对象
        User user = new User();
        user.setName("超人");
        user.setAge(20);
        redisTemplate.opsForValue().set(user.getName(), user);

        user = new User();
        user.setName("蝙蝠侠");
        user.setAge(30);
        redisTemplate.opsForValue().set(user.getName(), user);

        user = new User();
        user.setName("蜘蛛侠");
        user.setAge(40);
        redisTemplate.opsForValue().set(user.getName(), user);

        Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());
    }*/

    @Test
    public void contextLoads() {
    }
}
