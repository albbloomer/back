package com.company.store.sample.service;

import lombok.RequiredArgsConstructor;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SpringRetryTemplateService {

    private final SpringRetryTestService springRetryTestService;
    private final RetryTemplate retryTemplate;

    public String catImage(Long id) {
        return retryTemplate.execute(
                context -> springRetryTestService.cateImageByTemplate(id),
                context -> springRetryTestService.recoverByTemplate(id)
        );
    }
}
