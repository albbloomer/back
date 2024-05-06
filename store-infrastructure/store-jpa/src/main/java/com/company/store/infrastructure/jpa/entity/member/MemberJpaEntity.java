package com.company.store.infrastructure.jpa.entity.member;

import com.company.store.infrastructure.jpa.base.BaseJpaEntity;
import com.company.store.infrastructure.jpa.entity.team.TeamJpaEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "member")
public class MemberJpaEntity extends BaseJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamJpaEntity team;

    protected MemberJpaEntity() {
        //
    }

    public TeamJpaEntity getTeam() {
        return team;
    }

    public MemberJpaEntity(String name) {
        this.name = name;
    }

    public MemberJpaEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
