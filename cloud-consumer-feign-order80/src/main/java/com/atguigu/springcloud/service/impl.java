package com.atguigu.springcloud.service;


import com.atguigu.springcloud.pojo.CommonResult;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
public class impl implements TestService{

    @Override
    public CommonResult test(Integer id) {
        return null;
    }

    @Override
    public String chieshi() {

        return "feign的服务降级";
    }


}
