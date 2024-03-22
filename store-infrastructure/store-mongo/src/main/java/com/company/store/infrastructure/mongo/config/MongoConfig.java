package com.company.store.infrastructure.mongo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
        basePackages = {"com.company.store.infrastructure.mongo"}
)
public class MongoConfig {
    //
}
