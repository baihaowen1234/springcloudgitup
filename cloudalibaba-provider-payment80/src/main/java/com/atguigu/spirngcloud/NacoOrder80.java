package com.atguigu.spirngcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//注册中心
@EnableDiscoveryClient
//激活Feign
@EnableFeignClients
public class NacoOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(NacoOrder80.class,args);
    }
}
