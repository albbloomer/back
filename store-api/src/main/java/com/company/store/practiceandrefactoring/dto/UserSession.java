package com.company.store.practiceandrefactoring.dto;

import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class UserSession implements Serializable {

    private final String name;
    private final LocalDateTime updateTime;
    private final List<Cart> bookList;

    public UserSession(
            String name,
            LocalDateTime updateTime,
            List<Cart> bookList
    ) {
       this.name = name;
       this.updateTime = updateTime;
       this.bookList = bookList;
    }

    @Getter
    public static class Cart implements Serializable {

        private final Long id;
        private final String name;

        public Cart(
                Long id,
                String name
        ) {
            this.id = id;
            this.name = name;
        }
    }
}
