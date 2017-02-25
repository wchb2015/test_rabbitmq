package com.ximalaya.rabbitmq.helloworld;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
<<<<<<< HEAD
import org.springframework.amqp.core.Message;
=======
>>>>>>> 0e64191175cc1f07721972653c7b33d76206bbc7
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD

@Service("messageProducerService")
=======
@Service
>>>>>>> 0e64191175cc1f07721972653c7b33d76206bbc7
public class MessageProducerService {

    @Autowired
    private AmqpAdmin admin;
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private ConnectionFactory connectionFactory;

    public void pushToMessageQueue(String routingKey, String message) {
        amqpTemplate.convertAndSend(routingKey, message);
    }
<<<<<<< HEAD


=======
>>>>>>> 0e64191175cc1f07721972653c7b33d76206bbc7
}
