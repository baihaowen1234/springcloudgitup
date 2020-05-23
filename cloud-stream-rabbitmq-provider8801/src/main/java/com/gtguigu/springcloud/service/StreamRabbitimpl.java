package com.gtguigu.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

@EnableBinding(Source.class) //建立input传输通道 Source :传输的管道
public class StreamRabbitimpl implements StreamRabbitService {
@Autowired
private MessageChannel output;//定义发送的消息内容的载体

    @Override
    public MessageChannel send() {
        final String string ="不同id内容"+ UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(string).build());
        System.out.println(string);
        return null;
    }
}
