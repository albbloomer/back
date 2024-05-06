package com.company.store.infrastructure.jpa.entity.team;

import com.company.store.infrastructure.jpa.base.BaseJpaEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "team")
public class TeamJpaEntity extends BaseJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    protected TeamJpaEntity() {
        //
    }

    public TeamJpaEntity(Long id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}
