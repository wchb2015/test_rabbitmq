package com.ximalaya.rabbitmq.helloworld;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("messageConsumerService")
public class MessageConsumerService {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void popMessage(String destinationQueueName) {
        Message message = amqpTemplate.receive(destinationQueueName);
        System.out.println(new String(message.getBody()));
    }

}