package com.ximalaya.rabbitmq.worker;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Master {
    public static final String QUEUE_NAME = "work_queue7";

    public static void main(String[] args) throws IOException, TimeoutException {
//     1.建立连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

//     2.声明Queue
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
//     3.发送消息

        for (int i = 0; i < 10; i++) {
            String message = "_______Task-" + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        }
        connection.close();
    }
}
