package com.example.demo.service;

import com.example.demo.domain.City;

/**
 * Created by qjzhuo on 2018-08-06.
 */
public interface CityService {

    City findCityByName(String cityName);
}
