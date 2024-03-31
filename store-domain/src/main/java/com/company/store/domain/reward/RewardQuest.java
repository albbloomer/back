package com.company.store.domain.reward;

public class RewardQuest {
    private Integer id;
    private Integer order;
    private String title;
    private String description;
    private String questUrl;
    private String questComponent;
    private String questType;

    public RewardQuest(
            Integer id,
            Integer order,
            String title,
            String description,
            String questUrl,
            String questComponent,
            String questType
    ) {
        this.id = id;
        this.order = order;
        this.title = title;
        this.description = description;
        this.questUrl = questUrl;
        this.questComponent = questComponent;
        this.questType = questType;
    }

    public Integer getId() {
        return id;
    }

    public Integer getOrder() {
        return order;
    }

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
}
