package com.ele.rabbitmq.helloworld;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {

    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private ConnectionFactory connectionFactory;

    public void pushToMessageQueue(String routingKey, String message) {
        amqpTemplate.convertAndSend(routingKey, message);
    }
}
