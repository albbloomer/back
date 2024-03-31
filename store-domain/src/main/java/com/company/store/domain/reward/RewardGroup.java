package com.company.store.domain.reward;

public class RewardGroup {

    protected String id;
    private String name;
    private String description;
    private Integer order;

    public RewardGroup(
            String id,
            String name,
            String description,
            Integer order) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.order = order;
    }

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
}
