package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TController {
    public static final  String CONSUL_URL="http://consul-provider-payment";

    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/qqqq")
    public String ce(){
     return    restTemplate.getForObject(CONSUL_URL+"/Consultest",String.class);
    }

}
