package com.company.store.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BaseKafkaConsumer {

    @KafkaListener(topics = "example-topic", groupId = "${kafka.group-id}")
    public void consumeMessage(String message) {
        System.out.println("Consumed message: " + message);
    }
}