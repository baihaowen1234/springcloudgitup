package com.gtguigu.springcloud.service;

import org.springframework.messaging.MessageChannel;

public interface StreamRabbitService {

    public MessageChannel send();

}
