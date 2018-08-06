package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by qjzhuo on 2018-08-06.
 */
@Configuration
public class MessageConfig {
    @Bean
    public String message() {
        return "message configuration";
    }
}
