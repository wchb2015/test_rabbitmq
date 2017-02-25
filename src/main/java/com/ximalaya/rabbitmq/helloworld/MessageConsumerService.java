package com.ximalaya.rabbitmq.helloworld;

<<<<<<< HEAD

=======
>>>>>>> 0e64191175cc1f07721972653c7b33d76206bbc7
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("messageConsumerService")
public class MessageConsumerService {
<<<<<<< HEAD
=======

>>>>>>> 0e64191175cc1f07721972653c7b33d76206bbc7
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void popMessage(String destinationQueueName) {
        Message message = amqpTemplate.receive(destinationQueueName);
        System.out.println(new String(message.getBody()));
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> 0e64191175cc1f07721972653c7b33d76206bbc7
