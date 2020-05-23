package com.atguigu.springcloud.service;

import com.atguigu.springcloud.pojo.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface TestService {
    @GetMapping("/nihao/{id}")
    public CommonResult test(@PathVariable("id") Integer id);
    @GetMapping("/hyst")
    public  String chieshi();
}
