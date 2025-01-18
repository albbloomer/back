package com.company.store.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @KafkaListener(topics = "example-topic", groupId = "${kafka.group-id}")
    public void listen(@Payload String message) {
        System.out.println("Received message: " + message);
    }
}
