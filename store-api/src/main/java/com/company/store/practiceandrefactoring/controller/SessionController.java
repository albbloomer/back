package com.company.store.practiceandrefactoring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    @RequestMapping("/session")
    public String helloAdmin() {
        return "hello admin";
    }
}