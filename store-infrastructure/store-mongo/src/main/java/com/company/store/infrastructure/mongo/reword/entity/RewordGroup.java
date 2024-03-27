package com.company.store.infrastructure.mongo.reword.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "reward-mission-group")
public class RewordGroup extends BaseTimeEntity{

    @Field(name = "group_name")
    private String name;

    @Field(name = "description")
    private String description;

    @Field(name = "order")
    private Integer order;

    @Field(name = "modifier")
    private String modifier;

    @Field(name = "is_deleted")
    private Boolean isDeleted;
}