package com.company.external.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParamBindingTestController {

    @GetMapping("/test")
    public String test(TestRequest testReqeust) {
        System.out.println("===========================");
        System.out.println(testReqeust.getName());
        System.out.println(testReqeust.getNumber());
        return "test";
    }

    @Getter
    @Setter
    static class TestRequest {
        private String name;
        private Integer number;
    }
}
