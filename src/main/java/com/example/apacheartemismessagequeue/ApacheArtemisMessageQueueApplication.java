package com.example.apacheartemismessagequeue;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApacheArtemisMessageQueueApplication {

    private JmsMessageProducer jmsMessageProducer;

    public ApacheArtemisMessageQueueApplication(JmsMessageProducer jmsMessageProducer) {
        this.jmsMessageProducer = jmsMessageProducer;
    }


    public static void main(String[] args) {
        SpringApplication.run(ApacheArtemisMessageQueueApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            jmsMessageProducer.sendMessage("Hello world");
        };
    }
}
