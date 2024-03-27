package com.company.store.infrastructure.mongo.reward.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document
public abstract class BaseTimeEntity {

    @CreatedDate
    @Field(name = "created_date")
    protected LocalDateTime createdDate;

    @LastModifiedDate
    @Field(name = "updated_date")
    protected LocalDateTime updatedDate;
}
