package com.company.store.infrastructure.mongo.reward.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
public abstract class BaseTimeEntity {

    @CreatedDate
    @Field(name = "created_date")
    protected Date createdDate;

    @LastModifiedDate
    @Field(name = "updated_date")
    protected Date updatedDate;
}
