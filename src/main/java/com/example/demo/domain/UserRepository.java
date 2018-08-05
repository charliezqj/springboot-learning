package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/8/5.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
