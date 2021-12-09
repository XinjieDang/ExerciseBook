package com.dxj.one;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.impl.AMQConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 连接工具类
 */
public class RabbitMqUtils {
    //得到一个连接的channel
        public static Channel getChannel() throws Exception{
            //创建一个连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("192.168.56.10");
            factory.setUsername("guest");
            factory.setPassword("guest");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            return channel;
        }
}
