package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    RestTemplate restTemplate;
    public static final String Payment_Url = "http://CLOUD-PAYMENT-SERVICE";

    @GetMapping("/consumer/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Integer id) {
        log.info("内容++"+id);
        /*读取getForObject   写入postForObject*/

        return restTemplate.getForObject(Payment_Url+"/nihao/" + id, CommonResult.class);
    }


}
