package com.example.mbs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.mbs.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
    Optional<User>  findById(int id);

    @Query("SELECT u FROM User u WHERE u.name LIKE CONCAT(:prefix, '%')")
    List<User> findByNameStartingWith(@Param("prefix") String prefix);
 
}