package com.company.store.infrastructure.jpa.entity.member;

import jakarta.persistence.*;

@Entity
@Table(name = "member")
public class MemberJpaEntity {

    @Id
    private Long id;

    @Column(length = 100)
    private String name;

    protected MemberJpaEntity() {
        //
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
