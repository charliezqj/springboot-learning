package com.example.demo.service.impl;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qjzhuo on 2018-07-31.
 */
@Service
@CacheConfig(cacheNames = "books")
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(bookRepository.findAll());
    }

    @Override
    public Book insertByBook(Book book) {
        return bookRepository.save(book);
    }

    @CachePut(key = "#p0.id")
    @Override
    public Book update(Book book) {
        System.out.println(" call update method ");
        return bookRepository.save(book);
    }

    @CacheEvict(key = "#p0")
    @Override
    public Book delete(Long id) {
        System.out.println(" call delete method ");
        Book book = bookRepository.findById(id).get();
        bookRepository.delete(book);
        return book;
    }

    @Cacheable(key = "#p0")
    @Override
    public Book findById(Long id) {
        System.out.println(" call findById method ");
        return bookRepository.findById(id).get();
    }

    @Override
    public Book findByName(String name) {
        return bookRepository.findBook(name);
    }
}
