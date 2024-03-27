package com.company.store.infrastructure.mongo.reword.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.Date;
@Document
public abstract class BaseTimeEntity {

    @Id
    @Field(name = "_id", targetType = FieldType.OBJECT_ID)
    protected String id;

    @CreatedDate
    @Field(name = "created_date")
    protected Date createdDate;

    @LastModifiedDate
    @Field(name = "updated_date")
    protected Date updatedDate;
}
