package com.company.store.domain.reward;

import java.math.BigDecimal;

public class RewardMission {
    private String id;
    private String title;
    private BigDecimal point;
    private Integer order;

    public RewardMission(
            String id,
            String title,
            BigDecimal point,
            Integer order) {
        this.id = id;
        this.title = title;
        this.point = point;
        this.order = order;
    }

    public String getId() {
        return id;
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
}
