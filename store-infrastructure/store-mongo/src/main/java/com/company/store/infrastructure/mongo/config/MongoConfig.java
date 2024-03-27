package com.company.store.infrastructure.mongo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(
        basePackages = {"com.company.store.infrastructure.mongo"}
)
public class MongoConfig {
    //
}
