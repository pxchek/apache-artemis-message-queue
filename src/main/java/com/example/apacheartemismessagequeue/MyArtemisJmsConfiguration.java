package com.example.apacheartemismessagequeue;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;
import org.apache.activemq.artemis.jms.client.ActiveMQQueueConnectionFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

@Configuration(proxyBeanMethods = false)
public class MyArtemisJmsConfiguration {

    @Bean
    public DefaultJmsListenerContainerFactory myFactory(DefaultJmsListenerContainerFactoryConfigurer configurer) throws JMSException {
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        ConnectionFactory connectionFactory = getCustomConnectionFactory();
        configurer.configure(defaultJmsListenerContainerFactory, connectionFactory);
        MessageConverter messageConverter = new SimpleMessageConverter();
        defaultJmsListenerContainerFactory.setMessageConverter(messageConverter);
        return defaultJmsListenerContainerFactory;
    }

    private ConnectionFactory getCustomConnectionFactory() throws JMSException {
        ActiveMQQueueConnectionFactory activeMQQueueConnectionFactory = new ActiveMQQueueConnectionFactory();
        activeMQQueueConnectionFactory.setUser("admin");
        activeMQQueueConnectionFactory.setPassword("admin");
        activeMQQueueConnectionFactory.setBrokerURL("tcp://10.0.0.100:6616");
        return activeMQQueueConnectionFactory;
    }
}
