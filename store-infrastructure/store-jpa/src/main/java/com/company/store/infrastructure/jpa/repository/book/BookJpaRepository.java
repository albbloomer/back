package com.company.store.infrastructure.jpa.repository.book;

import com.company.store.infrastructure.jpa.entity.book.BookJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<BookJpaEntity, Long> {
    //
}
