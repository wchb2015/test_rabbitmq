package com.ele.rabbitmq.uitl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Arrays;

public class Bootstrap {

    public static ClassPathXmlApplicationContext context = null;

    private static Logger LOG = LoggerFactory.getLogger(Bootstrap.class);

    public static void main(String[] args) {
        try {
            if (args == null || args.length == 0) {
                LOG.info("spring server bootstrap use config file : application-context.xml under the classpath.");
                context = new ClassPathXmlApplicationContext("classpath:spring/application-context.xml");
            } else {
                new ClassPathXmlApplicationContext(args);
            }
            LOG.info("BeanDefinitionNames:{}", Arrays.asList(context.getBeanDefinitionNames()));
        } catch (Throwable t) {
            LOG.error("Throwable Occurs in Bootstrap!", t);
            System.exit(-1);
        }
    }
}
