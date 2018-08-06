package com.example.demo.web;

import com.example.demo.DemoApplicationTests;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by qjzhuo on 2018-08-06.
 */
//@RunWith(SpringRunner.class)
//@WebMvcTest(CityRestController.class)
//@WebAppConfiguration
public class CityRestControllerTest extends DemoApplicationTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testCityRestController() throws Exception {
        RequestBuilder request = null;
        request = get("/api/city")
                .param("cityName", "深圳");
        mvc.perform(request).andExpect(status().isOk());
    }
}