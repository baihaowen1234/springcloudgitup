package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


public interface OrderService {

    //新建订单
    void create(Order order);

    //修改订单状态，从零改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
