package com.example.springboottest.config;

import com.example.springboottest.callback.MsgSendConfirmCallBack;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitMQ配置
 */
@Slf4j
//@Configuration
public class RabbitMqConfig {
    /**
     * 消息交换器的名字
     */
    public static final String EXCHANGE = "exchangeTest";
    /**
     * 队列key1
     */
    public static final String ROUTINGKEY1 = "queue_one_key1";
    /**
     * 队列key2
     */
    public static final String ROUTINGKEY2 = "queue_one_key2";

    @Autowired
    private ExchangeConfig exchangeConfig;
    @Autowired
    private QueueConfig queueConfig;

    /**
     * 连接工厂
     */
    @Autowired
    private ConnectionFactory connectionFactory;

    /**
     * 将队列1和交换器绑定
     * @return
     */
    @Bean
    public Binding binding_one() {
        return BindingBuilder.bind(queueConfig.firstQueue()).to(exchangeConfig.directExchange()).with(RabbitMqConfig.ROUTINGKEY1);
    }
    /**
     * 将队列2和交换器绑定
     * @return
     */
    @Bean
    public Binding binding_two() {
        return BindingBuilder.bind(queueConfig.firstQueue()).to(exchangeConfig.directExchange()).with(RabbitMqConfig.ROUTINGKEY2);
    }


    /**
     * queue listener  观察 监听模式
     * 当有消息到达时会通知监听在对应的队列上的监听对象
     * @return
     */
    @Bean
    public SimpleMessageListenerContainer messageContainer() {
        //加载处理消息A的队列
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        //设置接收多个队列里面的消息，这里设置接收队列A
        //假如想一个消费者处理多个队列里面的信息可以如下设置：
        //container.setQueues(queueA(),queueB(),queueC());
        //container.setQueues(firstQueue());
        container.setQueues(queueConfig.firstQueue(), queueConfig.secondQueue());
        container.setExposeListenerChannel(true);
        //设置最大的并发的消费者数量
        container.setMaxConcurrentConsumers(10);
        //最小的并发消费者的数量
        container.setConcurrentConsumers(1);
        //设置确认模式手工确认
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setMessageListener(new ChannelAwareMessageListener() {
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                /**通过basic.qos方法设置prefetch_count=1，这样RabbitMQ就会使得每个Consumer在同一个时间点最多处理一个Message，
                 换句话说,在接收到该Consumer的ack前,它不会将新的Message分发给它 */
                channel.basicQos(1);
                byte[] body = message.getBody();
                log.info("接收处理队列A当中的消息:" + new String(body));
                /**为了保证永远不会丢失消息，RabbitMQ支持消息应答机制。
                 当消费者接收到消息并完成任务后会往RabbitMQ服务器发送一条确认的命令，然后RabbitMQ才会将消息删除。*/
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            }
        });
        return container;
    }
    /**
     * 定义rabbit template用于数据的接收和发送
     * @return
     */
    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        /**若使用confirm-callback或return-callback，
         * 必须要配置publisherConfirms或publisherReturns为true
         * 每个rabbitTemplate只能有一个confirm-callback和return-callback
         */
        template.setConfirmCallback(msgSendConfirmCallBack());
        //template.setReturnCallback(msgSendReturnCallback());
        /**
         * 使用return-callback时必须设置mandatory为true，或者在配置中设置mandatory-expression的值为true，
         * 可针对每次请求的消息去确定’mandatory’的boolean值，
         * 只能在提供’return -callback’时使用，与mandatory互斥
         */
          //template.setMandatory(true);
        return template;
    }

    /**
     * 消息确认机制
     * Confirms给客户端一种轻量级的方式，能够跟踪哪些消息被broker处理，
     * 哪些可能因为broker宕掉或者网络失败的情况而重新发布。
     * 确认并且保证消息被送达，提供了两种方式：发布确认和事务。(两者不可同时使用)
     * 在channel为事务时，不可引入确认模式；同样channel为确认模式下，不可使用事务。
     * @return
     */
    @Bean
    public MsgSendConfirmCallBack msgSendConfirmCallBack(){
        return new MsgSendConfirmCallBack();
    }


}
