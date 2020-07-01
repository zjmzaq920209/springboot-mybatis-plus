package com.example.springboottest.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * 消费者
 */
//@Component
public class FirstConsumer {

    @RabbitListener(queues = {"first-queue","second-queue"})
    public void handleMessage(@Payload String message) throws Exception {
        // 处理消息
        System.out.println("FirstConsumer {} handleMessage :"+message);
    }
}
