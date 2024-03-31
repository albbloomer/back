package com.company.store.infrastructure.mongo.reward.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "reward-group")
public class RewardGroupEntity extends BaseTimeEntity{

    @Id
    @Field(name = "_id", targetType = FieldType.OBJECT_ID)
    protected String id;

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

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getOrder() {
        return order;
    }

    public String getModifier() {
        return modifier;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }
}