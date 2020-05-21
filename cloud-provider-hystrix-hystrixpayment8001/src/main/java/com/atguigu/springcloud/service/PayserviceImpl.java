package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@DefaultProperties(defaultFallback = "timeout")
public class PayserviceImpl implements PayService {
    @Override
    public String ceshi() {
        int i=10/0;

        return "服务没有降级";
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启熔断器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),    //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //熔断的持续时间，当过了10秒会放一个请求判断是否继续熔断
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  //请求次数10次错误率达到60%   错误率达到多少的时候打开服务熔断
    })
    @Override
    public String rongduan(@PathVariable("id") int id) {
        if (id==0){
            int q=10/0;
        }
        final String simpleUUID = IdUtil.simpleUUID();

        return "服务器没有熔断正常"+simpleUUID;
    }

    public String timeout(){
        return "服务降级+服务器熔断";
    }

}
