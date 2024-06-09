package com.company.store.infrastructure.mybatis.config.database;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import javax.sql.DataSource;

@Configuration
public class YulDataSourceConfig extends BaseDataSource {

    @ConfigurationProperties(prefix = "spring.datasource.yul.v0")
    @Bean(name = "v0DataSourceA")
    public DataSource v0DataSourceA() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "v0DataSource")
    public DataSource v0DataSource(@Qualifier("v0DataSourceA") DataSource v0DataSourceA) {
        return new LazyConnectionDataSourceProxy(v0DataSourceA);
    }

    @ConfigurationProperties(prefix = "spring.datasource.yul.v1")
    @Bean(name = "v1DataSourceA")
    public DataSource v1DataSourceA() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "v1DataSource")
    public DataSource v1DataSource(@Qualifier("v1DataSourceA") DataSource v1DataSourceA) {
        return new LazyConnectionDataSourceProxy(v1DataSourceA);
    }

    @ConfigurationProperties(prefix = "spring.datasource.yul.v2")
    @Bean(name = "v2DataSourceA")
    public DataSource v2DataSourceA() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "v2DataSource")
    public DataSource v2DataSource(@Qualifier("v2DataSourceA") DataSource v2DataSourceA) {
        return new LazyConnectionDataSourceProxy(v2DataSourceA);
    }
}
