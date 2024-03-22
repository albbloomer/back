package com.company.store.practiceandrefactoring.dto;

import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class UserSession implements Serializable {

    @Serial
    private static final long serialVersionUID = -3664674482782849221L;

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

        @Serial
        private static final long serialVersionUID = -3664674482782849220L;

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
