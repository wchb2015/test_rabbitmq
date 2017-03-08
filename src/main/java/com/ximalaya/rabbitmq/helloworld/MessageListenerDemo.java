package com.ximalaya.rabbitmq.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class MessageListenerDemo implements MessageListener {

    private static final String CHARSET = "utf-8";

    Logger LOG = LoggerFactory.getLogger(MessageListenerDemo.class);

    public void onMessage(Message message) {
        parseMessage(message);
    }

    private void parseMessage(Message message) {
        try {
            String content = new String(message.getBody(), CHARSET);
            LOG.info("message : {}", content);
            throw new RuntimeException();
        } catch (Exception e) {
            LOG.error("parse mq message error1. {}", e);
        }
    }
}
