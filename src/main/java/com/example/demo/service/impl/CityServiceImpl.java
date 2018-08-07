package com.example.demo.service.impl;

import com.example.demo.dao.CityDao;
import com.example.demo.domain.City;
import com.example.demo.service.CityService;
import com.example.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by qjzhuo on 2018-08-06.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }

    @Override
    public City findCityById(Long id) {

        // 从缓存中获取城市信息
        String key = "city_" + id;
        if (redisUtil.exists(key)) {
            City city = (City) redisUtil.get(key);
            return city;
        }

        City city = cityDao.findById(id);
        redisUtil.set(key, city, 10 * 6 * 1000L);
        return city;
    }

    @Override
    public Long saveCity(City city) {
        return cityDao.saveCity(city);
    }

    @Override
    public Long updateCity(City city) {
        Long ret = cityDao.updateCity(city);

        String key = "city_" + city.getId();
        if (redisUtil.exists(key)) {
            redisUtil.remove(key);
        }
        return ret;
    }

    @Override
    public Long deleteCity(Long id) {
        Long ret = cityDao.deleteCity(id);

        String key = "city_" + id;
        if (redisUtil.exists(key)) {
            redisUtil.remove(key);
        }
        return ret;
    }
}
