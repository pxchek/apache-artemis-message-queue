package com.example.apacheartemismessagequeue;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageConsumer {

    private final JmsTemplate jmsTemplate;

    public JmsMessageConsumer(JmsTemplate template) {
        this.jmsTemplate = template;
    }

    @JmsListener(destination = "exampleQueue")
    public void receiveMessage(String message) {
        System.out.println(message + " and Processed");
    }
}
