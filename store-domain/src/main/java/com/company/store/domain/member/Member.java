package com.company.store.domain.member;

public class Member {

    private Long id;
    private String name;

    public Member(Long id) {
        this.id = id;
    }

    public Member(Long id, String name) {
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
