package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Administrator on 2018/8/5.
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByName(String name);

    Book findByNameAndWriter(String name, String writer);

    @Query("from Book b where b.name=:name")
    Book findBook(@Param("name") String name);
}
