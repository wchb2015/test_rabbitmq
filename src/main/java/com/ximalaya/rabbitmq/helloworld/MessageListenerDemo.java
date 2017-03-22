package com.ximalaya.rabbitmq.helloworld;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

import java.io.UnsupportedEncodingException;

public class MessageListenerDemo implements MessageListener, ChannelAwareMessageListener {

    private static final String CHARSET = "utf-8";

    Logger LOG = LoggerFactory.getLogger(MessageListenerDemo.class);

    public void onMessage(Message message) {
        parseMessage(message);
    }

    private void parseMessage(Message message) {
        try {
            String content = new String(message.getBody(), CHARSET);
            if (content.contains("99")) {
                LOG.error("This is a error!!!");
//                throw new RuntimeException();
            }
            LOG.info("insert2DB success: {}", content);
        } catch (UnsupportedEncodingException e) {
            LOG.error("parse mq message error.", e);
        }
    }

    public void onMessage(Message message, Channel channel) throws Exception {
        try {
            parseMessage(message);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        }
    }
}
