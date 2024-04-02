package com.company.store.config;

import com.company.store.MyTestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

    @Bean
    public MyTestBean myTestBean() {
        return new MyTestBean();
    }
}