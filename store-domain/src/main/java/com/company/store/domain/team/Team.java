package com.company.store.domain.team;

public class Team {

    private Long id;
    private String name;
    private String content;

    public Team() {
        //
    }

    public Team(Long id, String name, String content) {
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
