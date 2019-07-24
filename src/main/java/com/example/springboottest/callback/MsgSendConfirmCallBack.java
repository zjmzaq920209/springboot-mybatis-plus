package com.example.springboottest.callback;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * 消息发送到交换机确认机制
 */
public class MsgSendConfirmCallBack implements RabbitTemplate.ConfirmCallback {


    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println("MsgSendConfirmCallBack ,回调Id" + correlationData);
        if (b) {
            System.out.println("消息消费成功！");
        } else {
            System.out.println("消息消费失败！:" + s + "\n重新发送");
        }
    }
}
