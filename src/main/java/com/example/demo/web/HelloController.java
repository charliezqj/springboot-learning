package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by qjzhuo on 2018-07-23.
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model m) {
        String now = DateFormat.getDateTimeInstance().format(new Date());
        m.addAttribute("now", now);
        return "hello";
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://www.ctrip.com");
        return "index";
    }
}
