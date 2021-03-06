package com.ele.rabbitmq.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Sender {

    public static final String QUEUE_4 = "queue_0410";

    public static void main(String[] args) throws IOException, TimeoutException {
//     1.建立连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("182.92.188.170");
        factory.setUsername("admin");
        factory.setPassword("111111");
        factory.setVirtualHost("test0410");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

//     2.声明Queue
        /**
         * queue - the name of the queue
         durable - true if we are declaring a durable queue (the queue will survive a server restart)
         exclusive - true if we are declaring an exclusive queue (restricted to this connection)
         autoDelete - true if we are declaring an autodelete queue (server will delete it when no longer in use)
         arguments - other properties (construction arguments) for the queue
         */
        channel.queueDeclare(QUEUE_4, true, false, false, null);
//     3.发送消息

        /**
         * exchange - the exchange to publish the message to
         routingKey - the routing key
         props - other properties for the message - routing headers etc
         body - the message body
         */

        for (int i = 1; i <= 10000; i++) {
            String message = "这个消息payload 哈哈哈哈哈哈哈哈______" + i;
            channel.basicPublish("", QUEUE_4, null, message.getBytes());
        }
        channel.close();
        connection.close();

        System.out.println("*****end*****");
    }

}
