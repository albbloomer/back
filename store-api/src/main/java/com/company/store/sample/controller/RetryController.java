package com.company.store.sample.controller;

import com.company.store.sample.service.SpringRetryTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class RetryController {

    private final SpringRetryTestService springRetryTestService;

    @GetMapping("/cats/{id}/image")
    public String testRetryByCatImage(@PathVariable Long id) {
        return springRetryTestService.catImage(id);
    }
}
