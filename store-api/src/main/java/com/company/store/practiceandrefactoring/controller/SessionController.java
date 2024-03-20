package com.company.store.practiceandrefactoring.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    @GetMapping("/value/{value}")
    public ResponseEntity<Object> setSessionResult(
            HttpSession httpSession,
            @PathVariable("value") String value
    ) {
        Object attribute = httpSession.getAttribute("value");
        httpSession.setAttribute("value", value);
        return ResponseEntity.ok(attribute);
    }

    @GetMapping("/session")
    public ResponseEntity<Object> getSessionResult(HttpSession httpSession) {
        Object attribute = httpSession.getAttribute("value");
        return ResponseEntity.ok(attribute);
    }
}