package com.ximalaya.rabbitmq.worker;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class Worker {

    public static void main(String[] args) throws Exception {
//    1.建立连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
//    2.声明Queue
        channel.queueDeclare(Master.QUEUE_NAME, true, false, false, null);
        channel.basicQos(1);
//    3.创建Consumer
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(Master.QUEUE_NAME, true, consumer);
//    4.接收消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();

            String message = new String(delivery.getBody());
            execute(message);
        }
    }

    private static void execute(String task) throws InterruptedException {
        System.out.println("执行任务: " + task);
        Thread.sleep(1000);
    }

}
