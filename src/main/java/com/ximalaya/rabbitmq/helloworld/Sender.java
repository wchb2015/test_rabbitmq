package com.ximalaya.rabbitmq.helloworld;

<<<<<<< HEAD
=======

>>>>>>> 0e64191175cc1f07721972653c7b33d76206bbc7
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Sender {

    public static final String QUEUE_NAME = "test_queues";

    public static void main(String[] args) throws IOException, TimeoutException {
//     1.建立连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("182.92.188.170");

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
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
//     3.发送消息

        String message = "Hello World!71";
        /**
         * exchange - the exchange to publish the message to
         routingKey - the routing key
         props - other properties for the message - routing headers etc
         body - the message body
         */
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

        connection.close();
    }


}
