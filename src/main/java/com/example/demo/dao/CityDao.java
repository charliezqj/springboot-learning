package com.example.demo.dao;

import com.example.demo.domain.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by qjzhuo on 2018-08-06.
 */
//@Mapper // 标志为 Mybatis 的 Mapper
public interface CityDao {

    @Select("SELECT * FROM city WHERE city_name = #{cityName}")
    // 返回 Map 结果集
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description")
    })
    City findByName(@Param("cityName") String cityName);

    @Select("SELECT * FROM city")
    List<City> findAllCity();

    @Select("SELECT * FROM city WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description")
    })
    City findById(@Param("id") Long id);

    @Insert("INSERT INTO city(id, province_id, city_name, description) VALUES(#{id}, #{provinceId}, #{cityName}, #{description})")
    Long saveCity(City city);

    @Update("UPDATE city SET province_id = #{provinceId} WHERE id = #{id}")
    Long updateCity(City city);

    @Delete("DELETE FROM city WHERE id = #{id}")
    Long deleteCity(Long id);
}
