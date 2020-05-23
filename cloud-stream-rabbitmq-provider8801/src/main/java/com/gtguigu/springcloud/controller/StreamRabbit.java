package com.gtguigu.springcloud.controller;

import com.gtguigu.springcloud.service.StreamRabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StreamRabbit {
    @Autowired
    private StreamRabbitService streamRabbitService;

    @GetMapping("/chaxun")
    public  String chaxun(){
        streamRabbitService.send();
        return null;
    }
}
