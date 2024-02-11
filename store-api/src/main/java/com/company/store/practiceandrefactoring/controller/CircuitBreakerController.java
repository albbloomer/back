package com.company.store.practiceandrefactoring.controller;

import com.company.store.common.ResponseDto;
import com.company.store.practiceandrefactoring.service.CircuitBreakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/circuit")
@RestController
public class CircuitBreakerController {

    private final CircuitBreakerService circuitBreakerService;

    @GetMapping
    public ResponseDto<String> test() {

        return ResponseDto.ok("haha");
    }
}
