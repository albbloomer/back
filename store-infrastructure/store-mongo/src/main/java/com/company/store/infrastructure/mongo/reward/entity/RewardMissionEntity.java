package com.company.store.infrastructure.mongo.reward.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;
import java.util.List;

@Document(collection = "reward-mission")
public class RewardMissionEntity extends BaseTimeEntity {

    @Id
    @Field(name = "_id", targetType = FieldType.OBJECT_ID)
    protected String id;

    @Field(name = "group_id")
    private String groupId;

    @Field(name = "title")
    private String title;

    @Field(name = "point", targetType = FieldType.DECIMAL128)
    private BigDecimal point;

    @Field(name = "order")
    private Integer order;

    @Field(name = "activation")
    private Boolean activation;

    @Field(name = "quest")
    private List<RewardQuestEntity> quest;

    public String getId() {
        return id;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPoint() {
        return point;
    }

    public Integer getOrder() {
        return order;
    }

    public Boolean getActivation() {
        return activation;
    }
}