package com.example.apacheartemismessagequeue;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageProducer {
    private static int NUM_MESSAGES_COUNT = 1000000000;

    private final JmsTemplate jmsTemplate;

    public JmsMessageProducer(JmsTemplate template) {
        this.jmsTemplate = template;
    }

    public void sendMessage() throws InterruptedException {
        while (NUM_MESSAGES_COUNT > 0) {
            String message = "Web Order Submitted: WEB" + NUM_MESSAGES_COUNT;
            System.out.println(message);
            jmsTemplate.convertAndSend("exampleQueue", message);
            NUM_MESSAGES_COUNT--;
        }
    }
}
