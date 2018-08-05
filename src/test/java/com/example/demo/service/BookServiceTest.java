package com.example.demo.service;

import com.example.demo.domain.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/8/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void findAll() throws Exception {
        List<Book> bookList = bookService.findAll();
        Assert.assertTrue(bookList == null || bookList.isEmpty());
    }

    @Test
    public void insertByBook() throws Exception {
        Book book = new Book();
        book.setId(1L);
        book.setName("明朝那些事儿");
        book.setWriter("当年明月");
        book.setIntroduction("历史书");
        bookService.insertByBook(book);
    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void findById() throws Exception {

    }

    @Test
    public void findByName() throws Exception {
        String bookName = "明朝那些事儿";
        Book book = bookService.findByName(bookName);
        Assert.assertTrue(bookName.equals(book.getName()));
    }

}