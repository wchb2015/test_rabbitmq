package com.ele.rabbitmq.comsumer;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.UnsupportedEncodingException;

public class MessageListenerDemo implements MessageListener {

    private static final String CHARSET = "utf-8";

    Logger LOG = LoggerFactory.getLogger(MessageListenerDemo.class);

    public void onMessage(Message message) {
        parseMessage(message);
    }

    private void parseMessage(Message message) {
        try {
            String content = new String(message.getBody(), CHARSET);
            LOG.info("insert2DB success: {},thread:{}", content, Thread.currentThread().getName());
        } catch (UnsupportedEncodingException e) {
            LOG.error("parse mq message error.", e);
        }
    }

}
