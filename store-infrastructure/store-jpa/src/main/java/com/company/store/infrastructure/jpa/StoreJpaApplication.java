package com.company.store.infrastructure.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.company.store.infrastructure.jpa.repository"})
public class StoreJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreJpaApplication.class);
    }
}