package com.example.demo.dao;

import com.example.demo.domain.City;
import org.apache.ibatis.annotations.*;

/**
 * Created by qjzhuo on 2018-08-06.
 */
@Mapper // 标志为 Mybatis 的 Mapper
public interface CityDao {

    @Select("SELECT * FROM city")
    // 返回 Map 结果集
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description")
    })
    City findByName(@Param("cityName") String cityName);
}
