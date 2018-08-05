package com.example.demo.service;

import com.example.demo.domain.User;

import java.util.List;

/**
 * Created by Administrator on 2018/8/5.
 */
public interface UserService {

    List<User> findAll();

    User insertByUser(User user);

    User update(User user);

    User delete(Long id);

    User findById(Long id);
}
