package com.company.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveSetOperations;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.ReactiveRedisMessageListenerContainer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class SSEService {

    private final ReactiveRedisTemplate<String, String> redisTemplate;
    private final ReactiveSetOperations<String, String> setOperations;
    private final ReactiveRedisMessageListenerContainer messageListenerContainer;

    @Autowired
    public SSEService(ReactiveRedisTemplate<String, String> redisTemplate,
                      ReactiveRedisMessageListenerContainer messageListenerContainer) {
        this.redisTemplate = redisTemplate;
        this.setOperations = redisTemplate.opsForSet();
        this.messageListenerContainer = messageListenerContainer;
    }

    /**
     * 클라이언트가 특정 프로젝트에 대해 구독하는 메소드
     */
    public Flux<String> subscribe(Long userId, Long projectId) {
        String projectKey = "project:" + projectId;
        String userKey = "user:" + userId;

        // Redis에 해당 프로젝트에 대한 구독자 추가
        setOperations.add(projectKey, userKey)
                .doOnTerminate(() -> System.out.println("User " + userId + " subscribed to project " + projectId))
                .subscribe();

        // 구독을 위한 Redis 메시지 채널 설정
        subscribeToRedisTopic(projectKey);

        // Flux 반환: 메시지를 받아 클라이언트로 전송
        return Flux.merge(
                Flux.interval(Duration.ofSeconds(2)).map(seq -> "Fake message " + seq + " for project " + projectId),
                messageListenerContainer.receive(ChannelTopic.of(projectKey))
                        .map(message -> message.getMessage().toString())
        ).doOnTerminate(() -> System.out.println("Completed subscription"));
    }

    /**
     * Redis 메시지 채널에 구독
     */
    private void subscribeToRedisTopic(String projectKey) {
        String projectTopic = "project:topic:" + projectKey.split(":")[1];
        messageListenerContainer.receive(ChannelTopic.of(projectTopic))
                .map(message -> message.getMessage().toString())
                .subscribe(message -> {
                    // 메시지가 Redis에서 수신되면, 이를 모든 구독자에게 전달
                    // 실제 구독자에게 데이터를 전송하는 로직은 이곳에 위치
                });
    }

    /**
     * 2초마다 Kafka처럼 가짜 데이터를 발행하는 메소드
     */
    public void fakeKafkaData(Long projectId) {
        Flux.interval(Duration.ofSeconds(2))
                .map(seq -> "Fake message " + seq + " for project " + projectId)
                .doOnNext(message -> publishToProject(projectId, message))
                .subscribe();
    }

    /**
     * 프로젝트에 메시지를 발행하는 메소드
     */
    public void publishToProject(Long projectId, String message) {
        String projectTopic = "project:topic:" + projectId;

        // 메시지를 Redis에 발행
        redisTemplate.convertAndSend(projectTopic, message)
                .doOnTerminate(() -> System.out.println("Published message to Redis"))
                .subscribe();
    }
}
