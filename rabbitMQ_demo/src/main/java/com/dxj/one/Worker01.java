package com.dxj.one;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

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
