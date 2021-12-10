package com.dxj.one;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 测试消息轮询发送  分别发送4条消息 一定是 worker01 消息1 work02 消息2
 * worker01 消息3 work02 消息4
 */
public class Worker01 {
    private static final String QUEUE_NAME="hello";

    public static void main(String[] args) throws Exception {
        Channel channel=RabbitMqUtils.getChannel();
        DeliverCallback deliverCallback=(consumerTag,deliver)->{
            String receivedMessage=new String(deliver.getBody());
            System.out.println("接受消息"+receivedMessage);
        };
        CancelCallback cancelCallback=(consumerTag)->{
            System.out.println(consumerTag+"消费者取消消费的接口回调逻辑");
        };
        System.out.println("c2消费者启动等待消费....");
        channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback);
    }
}
