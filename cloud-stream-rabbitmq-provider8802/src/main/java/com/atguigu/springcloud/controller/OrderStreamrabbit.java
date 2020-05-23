package com.atguigu.springcloud.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class) //建立管道 使用Sink建立管道中的输入管道
public class OrderStreamrabbit {
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        final String payload = message.getPayload();
        System.out.println(payload);

    }

}
