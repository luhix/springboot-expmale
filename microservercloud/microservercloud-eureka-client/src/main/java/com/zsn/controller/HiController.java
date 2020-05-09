package com.zsn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HiController
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/4 15:21
 * @Version 1.0
 **/
@RestController
public class HiController {

    @Value("${server.port}")
    String port;

    // http://localhost:8762/hi?name=luhix
    @GetMapping("/hi")
    public String home(@RequestParam String name) {
        return "Hi " + name + ", i am from port: " +port;
    }
}
