package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.dao.PaymentMapper;
import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    PaymentMapper paymentMapper;
    @Value("${server.port}")
    String rotp;

    @GetMapping("/payment/eureka/findbyid/{id}")
    public CommonResult test(@PathVariable("id") Integer id) {

        final Payment payment = paymentMapper.getPayment(id);
        if (payment == null) {
            log.info("*********数据为空");
            return new CommonResult<>(404, "空数据+"+rotp+"");
        } else {
            log.info("*********数据" + payment);
            return new CommonResult<>(200, "数据成功"+rotp, payment);
        }

    }

    @PostMapping("/payment/eureka/save")
    public CommonResult<Payment> setnei(Payment payment) {

        final int i = paymentMapper.inserPayment(payment);
        if (i > 0) {
            new CommonResult<>(200, "返回成功", i);
        }

        return new CommonResult<>(200, "返回成功");
    }

}
