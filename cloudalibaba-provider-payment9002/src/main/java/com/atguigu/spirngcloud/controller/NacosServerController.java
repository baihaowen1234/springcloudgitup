package com.atguigu.spirngcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosServerController {
    @Value("${server.port}")
    private String port;


    @GetMapping("/Nacos/ceshi")
    public String ce(){
        System.out.println("Nacos调用");
        return "Nacos调用成功"+port;
    }
}
