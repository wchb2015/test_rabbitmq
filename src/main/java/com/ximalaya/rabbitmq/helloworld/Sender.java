package com.ximalaya.rabbitmq.helloworld;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Sender {

    public static final String QUEUE_NAME = "HELLO7";

    public static void main(String[] args) throws IOException, TimeoutException {
//     1.建立连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

//     2.声明Queue
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
//     3.发送消息

        String message = "Hello World!71";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

        connection.close();
    }

}
