package com.company.store.sample.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

@Service
public class SpringRetryTestService {

    private int counter = 0;
    private static final Logger logger = LoggerFactory.getLogger(SpringRetryTestService.class);

    // case 1
    @Retryable(
            maxAttempts = 3,
            backoff = @Backoff(delay = 1000),
            retryFor = RuntimeException.class // include deprecated
    )
    public String catImage(final Long id) {
        counter++;
        logger.info("counter: [{}]", counter);

        if (counter % 2 == 0) {
            return "cat_" + id + "_image.png";
        }

        throw new RuntimeException("Failed to get cat image.");
    }

    // case 2 -> recover option
    @Retryable(
            maxAttempts = 3,
            backoff = @Backoff(delay = 1000),
            retryFor = RuntimeException.class, // include deprecated
            recover = "recover"
    )
    public String catImageByRecover(final Long id) {
        counter++;
        logger.info("counter: [{}]", counter);

        if (counter % 2 == 0) {
            return "cat_" + id + "_image.png";
        }

        throw new RuntimeException("Failed to get cat image.");
    }

    @Recover
    public String recover(final Exception exception, final Long id) {
        logger.info("recover: [{}]", exception.getMessage(), exception);
        return "recover cat";
    }

    // case 3 -> retryTemplate
    @Configuration
    static class RetryTemplateConfig {

        @Bean
        public RetryTemplate retryTemplate() {
            return RetryTemplate.builder()
                    .maxAttempts(3)
                    .fixedBackoff(1000L)
                    .retryOn(RuntimeException.class)
                    .build();
        }
    }

    public String cateImageByTemplate(final Long id) {
        throw new RuntimeException("Failed to get cat image.");
    }

    public String recoverByTemplate(final Long id) {
        return "very_cute_cat_image.png";
    }

}