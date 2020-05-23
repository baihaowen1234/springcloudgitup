package com.atguigu.spirngcloud.controller;

import com.atguigu.spirngcloud.service.NacosServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosServerController {
    @Autowired
    private NacosServerService nacosServerService;
    @GetMapping("/ceshifangfa")
    public String fangfa(){
      return   nacosServerService.ce();
    }

}
