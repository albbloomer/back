package com.company.store.infrastructure.mybatis.repository.book;

import com.company.store.domain.book.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BookMapper {
    Book findById(@Param("id") long id);
}
