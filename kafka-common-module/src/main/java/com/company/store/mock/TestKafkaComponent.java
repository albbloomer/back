package com.company.store.mock;

import com.company.store.consumer.BaseKafkaConsumer;
import com.company.store.producer.BaseKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestKafkaComponent {

    @Autowired
    private BaseKafkaProducer baseKafkaProducer;

    @Autowired
    private BaseKafkaConsumer baseKafkaConsumer;

    private static final String TOPIC = "example-topic";

    // 메시지 발행 (10초마다 발행)
    @Scheduled(fixedRate = 10000)  // 10초마다 실행
    public void sendMessageToKafka() {
        String message = "Test message at " + System.currentTimeMillis();
        baseKafkaProducer.sendMessage(TOPIC, message);
        System.out.println("Published message: " + message);
    }

    // 메시지 소비 (TestKafkaComponent에서 직접 소비를 테스트)
    @Scheduled(fixedRate = 10000)  // 10초마다 실행
    public void consumeMessageFromKafka() {
        // 여기서는 직접적으로 소비 메서드를 호출하는 대신,
        // KafkaListener가 자동으로 처리하도록 할 수 있습니다.
        // 테스트용으로는 다른 방법을 고려할 수도 있지만, 기본적으로 KafkaListener가 메시지를 소비합니다.
    }
}
