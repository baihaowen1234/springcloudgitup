package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

public interface PayService {
//服务降级
    public String ceshi();
//    服务熔断
    public String rongduan(@PathVariable("id") int id);


}
