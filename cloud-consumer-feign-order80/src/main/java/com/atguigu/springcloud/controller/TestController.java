package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import com.atguigu.springcloud.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestService testService;
    @GetMapping("/ceshi/{id}")
    public CommonResult<Payment> ceshi(@PathVariable("id") Integer id){
        final CommonResult<Payment> test = testService.test(id);
        return test;
    }


    @GetMapping("/fangfab")
    public String wq(){
        final String chieshi = testService.chieshi();
        return chieshi;
    }
}
