package com.example.demo.service;

import com.example.demo.domain.Book;

import java.util.List;

/**
 * Created by qjzhuo on 2018-07-31.
 */
public interface BookService {

    List<Book> findAll();

    Book insertByBook(Book book);

    Book update(Book book);

    Book delete(Long id);

    Book findById(Long id);

    Book findByName(String name);
}
