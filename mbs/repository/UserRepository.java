package com.example.mbs.repository;

import com.example.mbs.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByname(String name);
    User findById(int id);
}