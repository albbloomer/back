package com.company.store.infrastructure.jpa.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean(name = "jpaDataSource")
    public DataSource jpaDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}