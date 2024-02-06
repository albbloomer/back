package com.company.store.infrastructure.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class StoreConfig {

    @Bean("transactionManager")
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }
}
