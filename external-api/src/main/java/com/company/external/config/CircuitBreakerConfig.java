package com.company.external.config;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.core.registry.EntryAddedEvent;
import io.github.resilience4j.core.registry.EntryRemovedEvent;
import io.github.resilience4j.core.registry.EntryReplacedEvent;
import io.github.resilience4j.core.registry.RegistryEventConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class CircuitBreakerConfig {

    @Bean
    public RegistryEventConsumer<CircuitBreaker> circuitRegistryEventConsumer() {

        return new RegistryEventConsumer<>() {
            @Override
            public void onEntryAddedEvent(EntryAddedEvent<CircuitBreaker> entryAddedEvent) {
                log.info("RegistryEventConsumer.onEntryAddedEvent");

                CircuitBreaker.EventPublisher eventPublisher = entryAddedEvent.getAddedEntry().getEventPublisher();

                /**
                 * 각각의 이벤트들 전부 넣는 것이 아니라 서비스에 따른 적재적소로 적용 <br>
                 */
                eventPublisher.onEvent(event -> log.info("onEvent {}", event));
                eventPublisher.onSuccess(event -> log.info("onSuccess {}", event));
                eventPublisher.onCallNotPermitted(event -> log.info("onCallNotPermitted {}", event));
                eventPublisher.onError(event -> log.info("onError {}", event));
                eventPublisher.onIgnoredError(event -> log.info("onIgnoredError {}", event));
                eventPublisher.onStateTransition(event -> log.info("onStateTransition {}", event));
                eventPublisher.onSlowCallRateExceeded(event -> log.info("onSlowCallRateExceeded {}", event));
                eventPublisher.onFailureRateExceeded(event -> log.info("onFailureRateExceeded {}", event));

            }

            @Override
            public void onEntryRemovedEvent(EntryRemovedEvent<CircuitBreaker> entryRemoveEvent) {
                log.info("RegistryEventConsumer.onEntryRemovedEvent");
            }

            @Override
            public void onEntryReplacedEvent(EntryReplacedEvent<CircuitBreaker> entryReplacedEvent) {
                log.info("RegistryEventConsumer.onEntryReplacedEvent");
            }
        };
    }
}
