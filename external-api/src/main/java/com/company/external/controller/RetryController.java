package com.company.external.controller;

import com.company.external.service.RetryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class RetryController {

    private final RetryService retryService;

    public RetryController(RetryService retryService) {
        this.retryService = retryService;
    }


    @GetMapping("/api-call")
    public String apiCall(@RequestParam String param) {
        return retryService.process(param);
    }

};