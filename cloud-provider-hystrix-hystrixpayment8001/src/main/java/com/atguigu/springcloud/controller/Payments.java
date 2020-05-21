package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Payments {
    @Autowired
    private PayService payService;
    @GetMapping("/hyst")
    public  String chieshi(){
        final String ceshi = payService.ceshi();
        return ceshi;
    }

    @GetMapping("/hystss/{id}")
    public  String chieshiss(@PathVariable("id") int id){
        final String rongduan = payService.rongduan(id);
        return rongduan;
    }
}


