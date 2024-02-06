package com.company.store.practiceandrefactoring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeathCheckController {

    @GetMapping("health-check")
    public String healthCheck() {
        return "ok";
    }
}
