package com.company.store.infrastructure.mongo.reward.entity;

import java.time.LocalDateTime;

public class RewardQuestEntity extends BaseTimeEntity {

    private String title;
    private String description;
    private String questUrl;
    private String questComponent;
    private String questType;
    private Integer order;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String modifier;
    private Boolean activation;
    private Boolean isDeleted;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getQuestUrl() {
        return questUrl;
    }

    public String getQuestComponent() {
        return questComponent;
    }

    public String getQuestType() {
        return questType;
    }

    public Integer getOrder() {
        return order;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public String getModifier() {
        return modifier;
    }

    public Boolean getActivation() {
        return activation;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }
}