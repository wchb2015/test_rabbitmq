package com.ele.rabbitmq.helloworld;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageProducerService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void pushToMessageQueue(String routingKey, String message) {
        amqpTemplate.convertAndSend(routingKey, message);
    }
}
