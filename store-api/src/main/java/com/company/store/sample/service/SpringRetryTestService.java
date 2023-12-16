package com.company.store.sample.service;

import org.springframework.retry.annotation.Recover;
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
}