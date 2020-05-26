package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.mapper.seataMapper;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class impl implements OrderService {
    @Autowired
    private seataMapper seataMapper;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @GlobalTransactional(name = "wadawd",rollbackFor = Exception.class)
    @Override
    public void create(Order order) {
//        创建订单
        seataMapper.create(order);
        //       减少仓库货量
        storageService.cangku(order.getProductId(),order.getCount());
//          减少钱
        accountService.money(order.getUserId(),order.getMoney());

        seataMapper.update(order.getUserId(), order.getStatus());
    }

    @Override
    public void update(Long userId, Integer status) {

    }

}
