package me.ele.meepo.statistic.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.UnsupportedEncodingException;


public class ApolloSubsidyConsumer implements MessageListener {
    private static final String CHARSET = "utf-8";

    Logger LOG = LoggerFactory.getLogger(ApolloSubsidyConsumer.class);

    public void onMessage(Message message) {
        parseMessage(message);
    }

    private void parseMessage(Message message) {
        try {
            String content = new String(message.getBody(), CHARSET);
            LOG.info("ApolloSubsidyConsumer mq content : {}", content);
        } catch (UnsupportedEncodingException e) {
            LOG.error("ApolloSubsidyConsumer parse mq message error.", e);
        }
    }

}
