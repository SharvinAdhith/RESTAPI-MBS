package com.example.mbs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.mbs.entity.BoatHouse;  

public interface BoatHouseRepository extends JpaRepository<BoatHouse, Integer> {
    Optional<BoatHouse> findById(int id); // This comes with JpaRepository but you can explicitly declare it

    BoatHouse findByName(String name);

    @Query("SELECT b FROM BoatHouse b WHERE b.name LIKE CONCAT(:prefix, '%')")
    List<BoatHouse> findByAlphabet(@Param("prefix")String prefix);
}


