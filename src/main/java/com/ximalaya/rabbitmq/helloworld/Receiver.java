package com.ximalaya.rabbitmq.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class Receiver {

    public static void main(String[] args) throws Exception {
//    1.建立连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
//    2.声明Queue
        /**
         * queue - the name of the queue
           durable - true if we are declaring a durable queue (the queue will survive a server restart)
           exclusive - true if we are declaring an exclusive queue (restricted to this connection)
           autoDelete - true if we are declaring an autodelete queue (server will delete it when no longer in use)
           arguments - other properties (construction arguments) for the queue
         */
        channel.queueDeclare(Sender.QUEUE_NAME, true, false, false, null);
//    3.创建Consumer
        QueueingConsumer consumer = new QueueingConsumer(channel);

        /**
         * queue - the name of the queue
         autoAck - true if the server should consider messages acknowledged once delivered; false if the server should expect explicit acknowledgements
         callback - an interface to the consumer object
         */
        channel.basicConsume(Sender.QUEUE_NAME, true, consumer);
//    4.接收消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();

            String message = new String(delivery.getBody());
            System.out.println("message receive: " + message);
        }
    }

}
