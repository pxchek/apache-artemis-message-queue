package com.example.apacheartemismessagequeue;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageProducer {

    private final JmsTemplate jmsTemplate;

    public JmsMessageProducer(JmsTemplate template) {
        this.jmsTemplate = template;
    }

    public void sendMessage(String message) {
        System.out.println("*****MESSAGE SENT*****");
        jmsTemplate.convertAndSend("exampleQueue", message);
    }
}
