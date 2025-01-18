package com.company.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class KafkaModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaModuleApplication.class, args);
    }
}