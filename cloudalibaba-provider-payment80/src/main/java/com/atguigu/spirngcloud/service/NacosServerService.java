package com.atguigu.spirngcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
@FeignClient(value = "nacos-payment-provider",fallback = Impl.class)
public interface NacosServerService {
    @GetMapping("/Nacos/ceshi")
    public String ce();
}
