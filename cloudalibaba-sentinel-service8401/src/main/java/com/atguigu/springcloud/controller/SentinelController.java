package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelController {
    @GetMapping("/Sentinel/getA")
    @SentinelResource(value = "SentinelgetA",blockHandler = "ceshifangfa",fallback = "fafa")
    public String get(){
        int i=10/0;
        return "进入";
    }
    @GetMapping("/Sentinel/getB")
    public String getB(){
        return "进入";
    }
    public String ceshifangfa(BlockException blockException){
        return "ceshifangfa熔断触发";
    }
    public String fafa(Throwable blockException){
        return "JAVA运行报错了";
    }
}
