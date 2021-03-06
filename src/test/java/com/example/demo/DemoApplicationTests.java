package com.example.demo;

import com.example.demo.domain.City;
import com.example.demo.property.StudentProperties;
import com.example.demo.util.RedisUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

//    @Resource
//    private RedisTemplate<String, User> redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    /*@Test
    public void testRedis() throws Exception {
        if (redisTemplate.hasKey("超人")) {
            redisTemplate.delete("超人");
        }
        if (redisTemplate.hasKey("蝙蝠侠")) {
            redisTemplate.delete("蝙蝠侠");
        }
        if (redisTemplate.hasKey("蜘蛛侠")) {
            redisTemplate.delete("蜘蛛侠");
        }

        // 保存对象
        User user = new User();
        user.setName("超人");
        user.setAge(20);
        redisTemplate.opsForValue().set(user.getName(), user, 10, TimeUnit.MINUTES);

        user = new User();
        user.setName("蝙蝠侠");
        user.setAge(30);
        redisTemplate.opsForValue().set(user.getName(), user, 10, TimeUnit.MINUTES);

        user = new User();
        user.setName("蜘蛛侠");
        user.setAge(40);
        redisTemplate.opsForValue().set(user.getName(), user, 10, TimeUnit.MINUTES);

        User fromRedis = redisTemplate.opsForValue().get("超人");

        Assert.assertEquals(20, fromRedis.getAge().longValue());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());
    }*/

    @Test
    public void testCityRedis() throws Exception {
        Long id = 3L;
        Long seconds = 6 * 10L;
        String key = "city_" + id;
        City city = new City();
        city.setId(id);
        city.setCityName("上海");
        city.setProvinceId(23L);
        city.setDescription("魔都魔都");

        if (redisUtil.exists(key)) {
            City cacheCity = (City) redisUtil.get(key);
            System.out.println(cacheCity.getCityName() + " will be deleted ");
            redisUtil.remove(key);
        }

        System.out.println(" set new city ");
        redisUtil.set(key, city, seconds);

        System.out.println(" comparing... ");
        City cacheCity = (City) redisUtil.get(key);
        Assert.assertEquals(city.getCityName(), cacheCity.getCityName());
    }

    @Test
    public void contextLoads() {
    }
}
