package com.company.store.infrastructure.mongo.reward.entity;

import java.time.LocalDateTime;

public class RewardQuest extends BaseTimeEntity {

    private String title;
    private String description;
    private String questUrl;
    private String questComponent;
    private String questType;
    private Integer order;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean modifier;
    private Boolean activation;
    private Boolean isDeleted;

}