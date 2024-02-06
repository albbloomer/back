package com.company.store;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class StoreBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreBatchApplication.class, args);
    }

}