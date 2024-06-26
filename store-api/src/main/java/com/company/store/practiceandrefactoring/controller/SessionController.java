package com.company.store.practiceandrefactoring.controller;

import com.company.store.practiceandrefactoring.service.SessionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    private final SessionService sessionService;

    public SessionController(
            SessionService sessionService
    ) {
        this.sessionService = sessionService;
    }

    @GetMapping("/session-key/{zuid}")
    public String setSession(@PathVariable String zuid, @RequestParam String type) {
        if (type.equals("dto")) {
            sessionService.userSessionByDto(zuid);
        } else {
            sessionService.userSession(zuid);
        }
        return "ok";
    }

    @GetMapping("/attribute/{attribute}/value/{value}")
    public ResponseEntity<Object> setSessionResult(
            HttpSession httpSession,
            @PathVariable("attribute") String attribute,
            @PathVariable("value") String value
    ) {
        Object session = httpSession.getAttribute(attribute);

        /*
         * # spring.session.store-type 을 통해 spring session 에 대한 store type 을 명시적으로 구성하는 것은 더 이상 지원하지 않는다.
         * # 둘 이상의 세션 스토리지 구현체가 있을 때는 앞으로는 아래와 같이 고정된 순서에 따라서 세션 스토리지 구현체를 결정한다.
         * # 1. Redis
         * # 2. JDBC
         * # 3. Hazelcast
         * # 4. MongoDB
         * # Redis, JDBC, Hazelcast, MongoDB 순서 / 혹은 SessionRepository 를 구현
         *
         * 127.0.0.1:6379> hkeys "spring:session:sessions:1f02edf6-af33-48dd-aa59-9123a89433d2"
         *   1) "sessionAttr:a"
         *   2) "creationTime"
         *   3) "lastAccessedTime"
         *   4) "maxInactiveInterval"
         *   5) "sessionAttr:b"

           사용자 1)
         * spring:session:sessions:cd87281f-7c48-4435-a0c8-34bba7535746
         * sessionAttr:USER_SESSION_yeon
         * lastAccessedTime
         * maxInactiveInterval
         * sessionAttr:USER_SESSION_yul
         * creationTime

*          사용자 2)
         * spring:session:sessions:5d7c3f22-9b1d-4e3a-b14c-7a9b4d80e63e
         * sessionAttr:USER_SESSION_john
         * lastAccessedTime
         * maxInactiveInterval
         * sessionAttr:USER_SESSION_emily
         * creationTime
         */
        httpSession.setAttribute(attribute, value);
        return ResponseEntity.ok(session);
    }

    @GetMapping("/session")
    public ResponseEntity<Object> getSessionResult(HttpSession httpSession) {
        Object attribute = httpSession.getAttribute("value");
        return ResponseEntity.ok(attribute);
    }

    @GetMapping("/user/my-page")
    public ResponseEntity<String> userMyPage(HttpSession session) {
        String zuid = (String) session.getAttribute("zuid");
        return ResponseEntity.ok(zuid);
    }
}