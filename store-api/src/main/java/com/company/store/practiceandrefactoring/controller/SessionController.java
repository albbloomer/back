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

        /*
         * # spring.session.store-type 을 통해 spring session 에 대한 store type 을 명시적으로 구성하는 것은 더 이상 지원하지 않는다.
         * # 둘 이상의 세션 스토리지 구현체가 있을 때는 앞으로는 아래와 같이 고정된 순서에 따라서 세션 스토리지 구현체를 결정한다.
         * # 1. Redis
         * # 2. JDBC
         * # 3. Hazelcast
         * # 4. MongoDB
         * # Redis, JDBC, Hazelcast, MongoDB 순서 / 혹은 SessionRepository 를 구현
         */
        httpSession.setAttribute("value", value);
        return ResponseEntity.ok(attribute);
    }

    @GetMapping("/session")
    public ResponseEntity<Object> getSessionResult(HttpSession httpSession) {
        Object attribute = httpSession.getAttribute("value");
        return ResponseEntity.ok(attribute);
    }
}